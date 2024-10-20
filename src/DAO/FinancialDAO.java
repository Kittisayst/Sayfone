package DAO;

import DAOInterface.FinancialFn;
import DAOSevervice.StudentService;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.FinancialModel;
import Model.StudentModel;
import java.util.List;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Utility.JoPrepared;
import Utility.JoSheet;
import Utility.MyFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
                    model.getFoodMonth(),
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
                    new String[]{"Money", "TransferMoney", "FinancialMonth", "foodMonth", "FinancialComment", "AuthenUserID", "Discount", "OvertimePay", "foodMoney"}),
                    model.getMoney(),
                    model.getTransferMoney(),
                    model.getFinancialMonth(),
                    model.getFoodMonth(),
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            String csql = "SELECT FinancialID,RegisterID,fs.StudentID,Money,TransferMoney,SaveDate,FinancialMonth,foodMonth,FinancialComment,AuthenUserID,Discount,OvertimePay,UserID,foodMoney,state\n"
                    + "FROM tb_financial AS fs\n"
                    + "INNER JOIN tb_student AS st ON fs.StudentID=st.StudentID\n"
                    + "WHERE RegisterID=? AND st.Status=0  GROUP BY fs.StudentID ORDER BY fs.StudentID ASC";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(csql);
            pre.setInt(1, RegisterID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            String sql = "SELECT \n"
                    + "    r.ClassRoomName,\n"
                    + "    c.className\n"
                    + "FROM \n"
                    + "    tb_student s\n"
                    + "JOIN \n"
                    + "    tb_financial f ON s.StudentID = f.StudentID\n"
                    + "JOIN \n"
                    + "    tb_register r ON f.RegisterID = r.registerID\n"
                    + "JOIN tb_class AS c ON r.classID = c.classID\n"
                    + "WHERE \n"
                    + "    r.YearID = (SELECT MAX(YearID) FROM tb_register)\n"
                    + "    AND s.StudentID = ? GROUP BY s.StudentID";
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
            e.printStackTrace();
            return "ຜິດພາດຂໍ້ມູນ";
        } finally {
            connect.close();
        }
    }

    public String getLastClassByFinancialID(int FinancialID) {
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT r.ClassRoomName FROM tb_financial AS f\n"
                    + "INNER JOIN tb_register AS r ON f.RegisterID=r.registerID\n"
                    + "WHERE FinancialID=?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, FinancialID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return "ບໍ່ພົບຫ້ອງຮຽນ";
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return "ຜິດພາດ";
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
            e.printStackTrace();
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
                rs.getString(9),
                rs.getInt(10),
                rs.getInt(11),
                rs.getInt(12),
                rs.getInt(13),
                rs.getInt(14),
                rs.getBoolean(15)
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
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getSearchStudentRegistered(int RegisterID, String search) {
        JoConnect connect = new JoConnect();
        List<FinancialModel> models = new ArrayList<>();
        String createSearch = isNumber(search) ? "StudentNo LIKE ?" : "StudentName LIKE ?";
        try {
            String csql = "SELECT * FROM tb_financial\n"
                    + "INNER JOIN tb_student ON tb_financial.StudentID = tb_student.StudentID\n"
                    + "WHERE RegisterID=? AND " + createSearch + " GROUP BY tb_financial.StudentID";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(csql);
            System.out.println(pre);
            pre.setInt(1, RegisterID);
            pre.setString(2, "%" + search + "%");
            System.out.println(pre);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return models;
    }

    private boolean isNumber(String data) {
        return data.matches("-?\\d+(\\.\\d+)?");
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
            e.printStackTrace();
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
            e.printStackTrace();
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
                    + "REPLACE(GROUP_CONCAT(foodMonth),',[]', '') AS fmonth,\n"
                    + "GROUP_CONCAT(FinancialComment) AS comments,AuthenUserID,SUM(Discount) AS disSUM,OvertimePay,UserID,SUM(foodMoney) AS TotalFoodMoney,state \n"
                    + "FROM tb_financial WHERE RegisterID=" + RegisterID + " AND StudentID = " + StudentID;
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            if (rs.next()) {
                model = resultModel(rs);
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return model;
    }

    @Override
    public void ExportPayment(int RegisterID) {
        JoConnect connect = new JoConnect();
        JoAlert alert = new JoAlert();
        JoFileSystem fileSystem = new JoFileSystem();
        String sql = "SELECT * FROM tb_financial";
        try {
            String genfileName = "Report" + new MyFormat().getTime(new Date(), "HH-mm-ss") + ".xls";
            String csvFile = fileSystem.getUserPath() + "/Downloads/" + genfileName;
            System.out.println(fileSystem.getUserPath());
            // Write column names to CSV file
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            // Create header row
            String[] columns = {"ລຳດັບ", "ໄອດີ", "RegisterID", "ລະຫັດນັກຮຽນ", "ຈຳນວນເງິນ", "ເງິນໂອນ", "ວັນທີ່ບັນທຶກ", "ຈ່າຍປະຈຳເດືອນ", "ໝາຍເຫດ", "ຜູ້ອານຸມັດ", "ສ່ວນຫຼຸດ", "ຄ່າຈ່າຍຊ້າ", "ຜຸ້ລົງບັນຊີ", "ຄ່າອາຫານ"};
            JoSheet joSheet = new JoSheet(csvFile, "Data", columns);
            StudentService ss = new StudentService();
            int rowNum = 1;
            while (rs.next()) {
                StudentModel sm = ss.getStudentById(rs.getInt(3));
                joSheet.addRow(
                        rowNum++,
                        rowNum - 1,
                        rs.getString(1),
                        rs.getString(2),
                        sm.getFullName(),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)
                );
            }
            joSheet.getCreateSheet();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
            alert.messages("ສົ່ງອອກ Excel ສຳເລັດ!");
        }
    }

    @Override
    public List<FinancialModel> getReportUserFinancial(int YearID, int UserID, String dateStart, String dateEnd) {
        List<FinancialModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        String sql = "SELECT FinancialID,fn.RegisterID,StudentID,Money,TransferMoney,SaveDate,FinancialMonth,foodMonth,FinancialComment,AuthenUserID,Discount,OvertimePay,UserID,foodMoney,state \n"
                + "FROM tb_financial AS fn\n"
                + "INNER JOIN tb_register AS rs ON fn.RegisterID=rs.registerID\n"
                + "WHERE rs.yearID=? AND UserID=? AND SaveDate BETWEEN ? AND ? ORDER BY FinancialID DESC";
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, YearID);
            pre.setInt(2, UserID);
            pre.setString(3, dateStart);
            pre.setString(4, dateEnd);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getReportUserClassMoney(int registerID, int UserID) {
        List<FinancialModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        String sql = "SELECT * FROM tb_financial WHERE RegisterID=? AND UserID=?";
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, registerID);
            pre.setInt(2, UserID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getReportFood(int RegisterID) {
        List<FinancialModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        String sql = "SELECT * FROM tb_financial WHERE RegisterID=? AND foodMoney>0";
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, RegisterID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getReportFinancialByRegisterID(int RegisterID) {
        List<FinancialModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        String sql = "SELECT * FROM tb_financial WHERE RegisterID=? ORDER BY StudentID ASC";
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, RegisterID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return models;
    }

    public List<FinancialModel> getReportPaymentWithMonth(int registerID, String Month) {
        List<FinancialModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT FinancialID,RegisterID,tb_financial.StudentID,Money,TransferMoney,SaveDate,FinancialMonth,foodMonth,FinancialComment,"
                    + "AuthenUserID,Discount,OvertimePay,UserID,foodMoney,state \n"
                    + "FROM tb_financial\n"
                    + "INNER JOIN tb_student ON tb_financial.StudentID = tb_student.StudentID\n"
                    + "WHERE RegisterID=? "
                    + "AND JSON_CONTAINS(FinancialMonth, ?, '$')";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, registerID);
            pre.setString(2, Month);
            System.out.println(pre);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                FinancialModel model = resultModel(rs);
                models.add(model);
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return models;
    }

    public FinancialModel getReportPaymentWithAllMonth(int registerID, int studentID) {
        FinancialModel fm = new FinancialModel();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT\n"
                    + "FinancialID,\n"
                    + "RegisterID,\n"
                    + "StudentID,\n"
                    + "SUM(Money) AS total_money,\n"
                    + "SUM(TransferMoney) AS total_transfer,\n"
                    + "GROUP_CONCAT(FinancialMonth SEPARATOR ', ') AS converted_month,\n"
                    + "SUM(foodMoney) AS total_food_money,\n"
                    + "SUM(Discount) AS total_discount,\n"
                    + "SUM(OvertimePay) AS total_overpay,\n"
                    + "GROUP_CONCAT(FinancialComment SEPARATOR ', ') AS tota_FinancialComment \n"
                    + "FROM tb_financial\n"
                    + "WHERE RegisterID=" + registerID + " AND StudentID = " + studentID + "";
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            if (rs.next()) {
                fm = new FinancialModel(
                        rs.getInt("FinancialID"),
                        rs.getInt("RegisterID"),
                        rs.getInt("StudentID"),
                        rs.getInt("total_money"),
                        rs.getInt("total_transfer"),
                        null,
                        rs.getString("converted_month"),
                        "",
                        rs.getString("tota_FinancialComment"),
                        0,
                        rs.getInt("total_discount"),
                        rs.getInt("total_overpay"),
                        0,
                        rs.getInt("total_food_money"),
                        true);
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return fm;
    }

    public FinancialModel getReportFoodPaymentWithAllMonth(int registerID, int studentID) {
        FinancialModel fm = new FinancialModel();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT\n"
                    + "FinancialID,\n"
                    + "RegisterID,\n"
                    + "StudentID,\n"
                    + "SUM(foodMoney) AS total_food_money,\n"
                    + "GROUP_CONCAT(foodMonth SEPARATOR ', ') AS converted_fmonth,\n"
                    + "SUM(Discount) AS total_discount,\n"
                    + "SUM(OvertimePay) AS total_overpay,\n"
                    + "GROUP_CONCAT(FinancialComment SEPARATOR ', ') AS tota_FinancialComment \n"
                    + "FROM tb_financial\n"
                    + "WHERE RegisterID=" + registerID + " AND StudentID = " + studentID + "";
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            if (rs.next()) {
                fm = new FinancialModel(
                        rs.getInt("FinancialID"),
                        rs.getInt("RegisterID"),
                        rs.getInt("StudentID"),
                        0,
                        0,
                        null,
                        "",
                        rs.getString("converted_fmonth"),
                        rs.getString("tota_FinancialComment"),
                        0,
                        0,
                        0,
                        0,
                        rs.getInt("total_food_money"),
                        true);
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return fm;
    }

    public List<FinancialModel> getReportFoodPaymentWithMonth(int registerID, String Month) {
        List<FinancialModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT FinancialID,RegisterID,tb_financial.StudentID,Money,TransferMoney,SaveDate,FinancialMonth,foodMonth,FinancialComment,"
                    + "AuthenUserID,Discount,OvertimePay,UserID,foodMoney,state \n"
                    + "FROM tb_financial\n"
                    + "INNER JOIN tb_student ON tb_financial.StudentID = tb_student.StudentID\n"
                    + "WHERE RegisterID=? "
                    + "AND JSON_CONTAINS(foodMonth, ?, '$')";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, registerID);
            pre.setString(2, Month);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                System.out.println(pre);
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return models;
    }

    public String getDebtPaymentMonth(int registerID, int studentID) {
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT\n"
                    + "GROUP_CONCAT(FinancialMonth SEPARATOR ', ') AS converted_month\n"
                    + "FROM tb_financial\n"
                    + " WHERE RegisterID=" + registerID + " AND StudentID = " + studentID + "";
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            if (rs.next()) {
                return rs.getString("converted_month");
            } else {
                return "[]";
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return "[]";
    }

    public String getDebtFoodMonth(int registerID, int studentID) {
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT\n"
                    + "GROUP_CONCAT(foodMonth SEPARATOR ', ') AS converted_fmonth\n"
                    + "FROM tb_financial\n"
                    + " WHERE RegisterID=" + registerID + " AND StudentID = " + studentID + "";
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            if (rs.next()) {
                return rs.getString("converted_fmonth");
            } else {
                return "[]";
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return "[]";
    }

    public List<StudentModel> getStudentOldClass(int yearID, int classID) {
        List<StudentModel> models = new ArrayList<>();
        StudentService service = new StudentService();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT fc.StudentID FROM tb_financial AS fc\n"
                    + "INNER JOIN tb_register AS rs ON fc.RegisterID = rs.registerID\n"
                    + "INNER JOIN tb_student AS st ON fc.StudentID = st.StudentID\n"
                    + "WHERE rs.yearID=? AND rs.classID=? AND st.Status ='0'\n"
                    + "GROUP BY StudentID";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, yearID);
            pre.setInt(2, classID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(service.getStudentById(rs.getInt(1)));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            System.out.println(e.getMessage());
        } finally {
            connect.close();
        }
        return models;
    }

    public List<StudentModel> getStudentNew() {
        List<StudentModel> models = new ArrayList<>();
        StudentService service = new StudentService();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT st.StudentID \n"
                    + "FROM tb_student AS st\n"
                    + "LEFT JOIN tb_financial AS tf ON st.StudentID = tf.StudentID\n"
                    + "WHERE tf.StudentID IS NULL AND  st.Status=0";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(service.getStudentById(rs.getInt(1)));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            System.out.println(e.getMessage());
        } finally {
            connect.close();
        }
        return models;
    }

    public List<StudentModel> getStudentRepeat(int YearID) {
        List<StudentModel> models = new ArrayList<>();
        StudentService service = new StudentService();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT st.StudentID \n"
                    + "FROM tb_student AS st\n"
                    + "LEFT JOIN tb_financial AS tf ON st.StudentID = tf.StudentID\n"
                    + "WHERE tf.StudentID IS NULL AND  st.Status=0";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(service.getStudentById(rs.getInt(1)));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            System.out.println(e.getMessage());
        } finally {
            connect.close();
        }
        return models;
    }

    public boolean isOldStudentRegistered(int registerID, int studentID) {
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT StudentID FROM tb_financial WHERE RegisterID=? AND StudentID = ?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, registerID);
            pre.setInt(2, studentID);
            ResultSet rs = pre.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            System.out.println(e.getMessage());
            return false;
        } finally {
            connect.close();
        }
    }

    public int getCountOldStudent() {
        JoConnect connect = new JoConnect();
        int count = 0;
        try {
            String sql = "SELECT COUNT(DISTINCT st.StudentID)AS stCount FROM tb_student AS st\n"
                    + "INNER JOIN tb_financial AS tf ON st.StudentID = tf.StudentID\n"
                    + "WHERE  st.Status=0";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return count;
    }

    public int getCountStudentNew() {
        JoConnect connect = new JoConnect();
        int count = 0;
        try {
            String sql = "SELECT COUNT(st.StudentID)AS stCount FROM tb_student AS st\n"
                    + "LEFT JOIN tb_financial AS tf ON st.StudentID = tf.StudentID\n"
                    + "WHERE tf.StudentID IS NULL AND  st.Status=0";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return count;
    }

    public FinancialModel getSearchStudentInDash(int YearID, int StudentID) {
        FinancialModel financialModel = new FinancialModel();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT * FROM tb_financial AS fc\n"
                    + "INNER JOIN tb_register AS rg ON fc.RegisterID = rg.registerID\n"
                    + "WHERE rg.yearID = ? AND fc.StudentID=?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, YearID);
            pre.setInt(2, StudentID);
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

}
