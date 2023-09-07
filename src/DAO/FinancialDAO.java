package DAO;

import DAOInterface.FinancialFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.FinancialModel;
import java.util.List;
import Tools.JoAlert;
import Utility.JoPrepared;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FinancialDAO implements FinancialFn {

    private final String TableName = "tb_financial";

    @Override
    public int Creater(FinancialModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = setAutoPrepared(sql.getCreate(),
                    model.getFinancialIID(),
                    model.getRegisterID(),
                    model.getStudentID(),
                    model.getMoney(),
                    model.getTransferMoney(),
                    model.getFinancialDate(),
                    model.getFinancialMonth(),
                    model.getFinancialComment(),
                    model.getAuthenUserID(),
                    model.getDiscount(),
                    model.getOvertimePay(),
                    model.getUserID(),
                    model.getFoodMoney(),
                    model.isState());
            System.out.println(pre);
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public int Update(FinancialModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = new JoPrepared().setAutoPrepared(sql.getUpdateByColumns(
                    new String[]{"Money", "TransferMoney", "FinancialMonth", "FinancialComment", "AuthenUserID", "Discount", "OvertimePay", "foodMoney"}),
                    model.getMoney(),
                    model.getTransferMoney(),
                    model.getFinancialMonth(),
                    model.getFinancialComment(),
                    model.getAuthenUserID(),
                    model.getDiscount(),
                    model.getOvertimePay(),
                    model.getFoodMoney(),
                    model.getFinancialIID()
            );
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public int UpdateClassRoom(int RegisterOldClassID, int RegisterNewClassID, int StudentID) {
        JoConnect connect = new JoConnect();
        String sql = "UPDATE tb_financial SET RegisterID=? WHERE RegisterID=? AND StudentID=?";
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, RegisterNewClassID);
            pre.setInt(2, RegisterOldClassID);
            pre.setInt(3, StudentID);
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public int Delete(FinancialModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getFinancialIID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public List<FinancialModel> getFinancialAll() {  //ດຶງຂໍ້ມູນຈ່າຍຄ່າຮຽນທັງໝົດ
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<FinancialModel> financialModels = new ArrayList<>();
        financialModels.clear();
        ResultSet rs;
        try {
            rs = sql.getSelectAll();
            while (rs.next()) {
                financialModels.add(resultModel(rs));
            }
            rs.close();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return financialModels;
    }

    @Override
    public int getMaxFinancialID() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        int max = 0;
        try {
            ResultSet rs = sql.getMaxColumn();
            if (rs.next()) {
                max = rs.getInt(1);
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return max;
    }

    @Override
    public List<FinancialModel> getFinancialByStudentID(int RegisterID, int StudentID) { //ດຶງຂໍ້ມູນການຈ່າຍຄ່າຮຽນຕາໄອດີນັກຮຽນ
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<FinancialModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = sql.getSelectCustom("RegisterID=? AND StudentID=? AND state=1");
            pre.setInt(1, RegisterID);
            pre.setInt(2, StudentID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getStudentRegistered(int RegisterID) { // ດຶງຂໍ້ມູນນັກຮຽນທີ່ລົງທະບຽນແລ້ວ
        JoConnect connect = new JoConnect();
        List<FinancialModel> models = new ArrayList<>();
        try {
            String csql = "SELECT * FROM tb_financial WHERE RegisterID=? GROUP BY StudentID";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(csql);
            pre.setInt(1, RegisterID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public FinancialModel getFinancialById(int ID) {  //ດຶງຂໍ້ມູນການໂອນຕາມໄອດີ
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        FinancialModel model = new FinancialModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                model = resultModel(rs);
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

    @Override
    public List<FinancialModel> getFinancialReportByDate(String date, String userID) {  // ລາຍງານ ຂໍ້ມູນຈ່າຍຄ່າຮຽນປະຈຳວັນ ເງິນສົດ
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<FinancialModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = sql.getSelectCustom("SaveDate=? AND Money>0  AND state=1 AND UserID=?");
            pre.setString(1, date);
            pre.setString(2, userID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getFinancialReportByWeek(String date, String userID) { // ລາຍງານ ຂໍ້ມູນຈ່າຍຄ່າຮຽນປະຈຳ ອາທິດ ເງິນສົດ
        JoConnect connect = new JoConnect();
        List<FinancialModel> models = new ArrayList<>();
        try {
            String sqlc = "SELECT * FROM tb_financial WHERE SaveDate >= ? AND SaveDate <= DATE_ADD(?, INTERVAL 6 DAY) AND Money>0  AND state=1 AND UserID=?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sqlc);
            pre.setString(1, date);
            pre.setString(2, date);
            pre.setString(3, userID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getFinancialReportByDateToDate(String startDate, String endDate, String userID) { //ລາຍງານ ເງິນສົດປະຈຳ ວັນທີ
        JoConnect connect = new JoConnect();
        List<FinancialModel> models = new ArrayList<>();
        try {
            String sqlc = "SELECT * FROM tb_financial WHERE SaveDate BETWEEN ? AND ? AND Money>0  AND state=1 AND UserID=?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sqlc);
            pre.setString(1, startDate);
            pre.setString(2, endDate);
            pre.setString(3, userID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getFinancialReportByDateTransfer(String date, String userID) {  // ລາຍງານ ຂໍ້ມູນຈ່າຍຄ່າຮຽນປະຈຳວັນ ໂອນ
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<FinancialModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = sql.getSelectCustom("SaveDate=? AND TransferMoney>0  AND state=1 AND UserID=?");
            pre.setString(1, date);
            pre.setString(2, userID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getFinancialReportByWeekTransfer(String date, String userID) { // ລາຍງານ ເງິນໂອນປະຈຳ ອາທິດ
        JoConnect connect = new JoConnect();
        List<FinancialModel> models = new ArrayList<>();
        try {
            String sqlc = "SELECT * FROM tb_financial WHERE SaveDate >= ? AND SaveDate <= DATE_ADD(?, INTERVAL 6 DAY) AND TransferMoney>0  AND state=1 AND UserID=?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sqlc);
            pre.setString(1, date);
            pre.setString(2, date);
            pre.setString(3, userID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getFinancialReportByDateToDateTransfer(String startDate, String endDate, String userID) { //ລາຍງານ ເງິນໂອນປະຈຳ ວັນທີ
        JoConnect connect = new JoConnect();
        List<FinancialModel> models = new ArrayList<>();
        try {
            String sqlc = "SELECT * FROM tb_financial WHERE SaveDate BETWEEN ? AND ? AND TransferMoney>0  AND state=1 AND UserID=?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sqlc);
            pre.setString(1, startDate);
            pre.setString(2, endDate);
            pre.setString(3, userID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public String getLastClass(int StudentID) {
        JoConnect connect = new JoConnect();
        PreparedStatement pre;
        ResultSet rs;
        try {
            String sql = "SELECT MAX(FinancialID) AS MaxFinancialID,fn.RegisterID,rs.classID,className FROM tb_financial AS fn\n"
                    + "INNER JOIN tb_register AS rs ON fn.RegisterID=rs.registerID\n"
                    + "INNER JOIN tb_class AS cs ON rs.classID = cs.classID\n"
                    + "WHERE StudentID =?";
            pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, StudentID);
            rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getString("className") == null ? "ນັກຮຽນໃໝ່" : rs.getString("className");
            } else {
                return "ຜິດພາດຂໍ້ມູນ";
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return "ຜິດພາດຂໍ້ມູນ";
        } finally {
            connect.close();
        }
    }

    @Override
    public FinancialModel getLastRegister(int studentID) {
        FinancialModel financialModel = new FinancialModel();
        JoConnect connect = new JoConnect();
        String sql = "SELECT *, MAX(FinancialID)AS maxID FROM tb_financial WHERE StudentID=?";
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, studentID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                financialModel = resultModel(rs);
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return financialModel;
    }

    @Override
    public String getPayMonth(int RegisterID, int StudentID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private FinancialModel resultModel(ResultSet rs) throws Exception {
        return new FinancialModel(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getInt(5),
                rs.getDate(6),
                rs.getString(7),
                rs.getString(8),
                rs.getInt(9),
                rs.getInt(10),
                rs.getInt(11),
                rs.getInt(12),
                rs.getInt(13),
                rs.getBoolean(14)
        );
    }

    public static PreparedStatement setAutoPrepared(PreparedStatement pre, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pre.setObject(i + 1, params[i]);
        }
        return pre;
    }

    @Override
    public int getCountFinancial() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        int count = 0;
        try {
            count = sql.getCount();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        } finally {
            connect.close();
        }
        return count;
    }

    @Override
    public List<FinancialModel> getFinancialFree(int YearID) {
        JoConnect connect = new JoConnect();
        List<FinancialModel> models = new ArrayList<>();
        try {
            String sqlc = "SELECT * FROM tb_financial\n"
                    + "INNER JOIN tb_register ON tb_financial.RegisterID=tb_register.registerID\n"
                    + "WHERE yearID=? GROUP BY StudentID";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sqlc);
            pre.setInt(1, YearID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getSearchStudentRegistered(int RegisterID, String search) {
        JoConnect connect = new JoConnect();
        List<FinancialModel> models = new ArrayList<>();
        try {
            String csql = "SELECT * FROM tb_financial\n"
                    + "INNER JOIN tb_student ON tb_financial.StudentID = tb_student.StudentID\n"
                    + "WHERE RegisterID=? AND StudentNo LIKE ? OR StudentName LIKE ? GROUP BY tb_financial.StudentID";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(csql);
            pre.setInt(1, RegisterID);
            pre.setString(2, search);
            pre.setString(3, search);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public int getUpdateWithdrawMonth(int FinancialID) { // ແກ້ໄຂຕາມການຖອນເງິນ
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getUpdateByColumns(new String[]{"state"});
            pre.setBoolean(1, false);
            pre.setInt(2, FinancialID);
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public boolean getStudentIsReister(int StudentID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getSelectCustom("StudentID=?");
            pre.setInt(1, StudentID);
            ResultSet rs = pre.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return false;
        } finally {
            connect.close();
        }
    }

    @Override
    public FinancialModel getFinancialCalculator(int RegisterID, int StudentID) {
        JoConnect connect = new JoConnect();
        FinancialModel model = new FinancialModel();
        try {
            String sql = "SELECT FinancialID,RegisterID,StudentID,SUM(Money) AS totalMoney,\n"
                    + "SUM(TransferMoney) AS totalTransferMoney,SaveDate,\n"
                    + "REPLACE(GROUP_CONCAT(FinancialMonth),',[]', '') AS month,\n"
                    + "FinancialComment,AuthenUserID,Discount,OvertimePay,UserID,SUM(foodMoney) AS TotalFoodMoney,state \n"
                    + "FROM tb_financial WHERE RegisterID="+RegisterID+" AND StudentID = "+StudentID;
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            if (rs.next()) {
                model = resultModel(rs);
//                model = new FinancialModel(
//                        rs.getInt("FinancialID"),
//                        rs.getInt("RegisterID"),
//                        rs.getInt("StudentID"),
//                        rs.getInt("totalMoney"),
//                        rs.getInt("totalTransferMoney"),
//                        rs.getDate("SaveDate"),
//                        rs.getString("month"),
//                        rs.getString("FinancialComment"),
//                        rs.getInt("AuthenUserID"),
//                        rs.getInt("Discount"),
//                        rs.getInt("OvertimePay"),
//                        rs.getInt("UserID"),
//                        rs.getInt("TotalFoodMoney"),
//                        rs.getBoolean("state"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

    @Override
    public String getFinancialFoodTotal(int RegisterID, int StudentID) {
        JoConnect connect = new JoConnect();
        String total = "0";
        try {
            String sql = "SELECT SUM(foodMoney) AS TotalFoodMoney\n"
                    + "FROM tb_financial\n"
                    + "WHERE RegisterID = "+RegisterID+" AND StudentID = "+StudentID;
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            if (rs.next()) {
                System.out.println(rs.getBigDecimal("TotalFoodMoney"));
//                total =rs.getString("TotalFoodMoney");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return total;
    }

}
