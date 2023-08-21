package DAO;

import DAOInterface.FinancialFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.FinancialModel;
import Model.RegisterModel;
import java.util.List;
import Tools.JoAlert;
import Utility.JoPrepared;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FinancialDAO implements FinancialFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_financial";
    private final JoSQL sql = new JoSQL(c, TableName);

    @Override
    public int Creater(FinancialModel model) {
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
                    model.getUserID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int Update(FinancialModel model) {
        try {
            PreparedStatement pre = new JoPrepared().setAutoPrepared(sql.getUpdateByColumns(
                    new String[]{"Money", "TransferMoney", "SaveDate", "FinancialMonth", "FinancialComment", "AuthenUserID", "Discount", "OvertimePay", "UserID"}),
                    model.getMoney(),
                    model.getTransferMoney(),
                    model.getFinancialDate(),
                    model.getFinancialMonth(),
                    model.getFinancialComment(),
                    model.getAuthenUserID(),
                    model.getDiscount(),
                    model.getOvertimePay(),
                    model.getUserID(),
                    model.getFinancialIID()
            );
            System.out.println(pre);
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();;
            return 0;
        }
    }

    @Override
    public int Delete(FinancialModel model) {
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getFinancialIID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<FinancialModel> getFinancialAll() {
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
        }
        return financialModels;
    }

    @Override
    public int getMaxFinancialID() {
        int max = 0;
        try {
            ResultSet rs = sql.getMaxColumn();
            if (rs.next()) {
                max = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return max;
    }

    @Override
    public List<FinancialModel> getFinancialByStudentID(int RegisterID, int StudentID) {
        List<FinancialModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = sql.getSelectCustom("RegisterID=? AND StudentID=?");
            pre.setInt(1, RegisterID);
            pre.setInt(2, StudentID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public List<FinancialModel> getStudentRegistered(int RegisterID) {
        List<FinancialModel> models = new ArrayList<>();
        try {
            String csql = "SELECT * FROM tb_financial WHERE RegisterID=? GROUP BY StudentID";
            PreparedStatement pre = c.prepareStatement(csql);
            pre.setInt(1, RegisterID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public FinancialModel getFinancialById(int ID) {
        FinancialModel model = new FinancialModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                model = resultModel(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

    @Override
    public List<FinancialModel> getFinancialReportByDate(String date, String userID) {  // ດຶງຂໍ້ມູນຈ່າຍຄ່າຮຽນປະຈຳວັນ ເງິນສົດ
        List<FinancialModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = sql.getSelectCustom("SaveDate=? AND Money>0 AND UserID=?");
            pre.setString(1, date);
            pre.setString(2, userID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getFinancialReportByWeek(String date, String userID) { // ດຶງຂໍ້ມູນຈ່າຍຄ່າຮຽນປະຈຳ ອາທິດ ເງິນສົດ
        List<FinancialModel> models = new ArrayList<>();
        try {
            String sqlc = "SELECT * FROM tb_financial WHERE SaveDate >= ? AND SaveDate <= DATE_ADD(?, INTERVAL 6 DAY) AND Money>0 AND UserID=?";
            PreparedStatement pre = c.prepareStatement(sqlc);
            pre.setString(1, date);
            pre.setString(2, date);
            pre.setString(3, userID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getFinancialReportByDateToDate(String startDate, String endDate, String userID) {
        List<FinancialModel> models = new ArrayList<>();
        try {
            String sqlc = "SELECT * FROM tb_financial WHERE SaveDate BETWEEN ? AND ? AND Money>0 AND UserID=?";
            PreparedStatement pre = c.prepareStatement(sqlc);
            pre.setString(1, startDate);
            pre.setString(2, endDate);
            pre.setString(3, userID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getFinancialReportByDateTransfer(String date, String userID) {  // ດຶງຂໍ້ມູນຈ່າຍຄ່າຮຽນປະຈຳວັນ ໂອນ
        List<FinancialModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = sql.getSelectCustom("SaveDate=? AND TransferMoney>0 AND UserID=?");
            pre.setString(1, date);
            pre.setString(2, userID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getFinancialReportByWeekTransfer(String date, String userID) {
        List<FinancialModel> models = new ArrayList<>();
        try {
            String sqlc = "SELECT * FROM tb_financial WHERE SaveDate >= ? AND SaveDate <= DATE_ADD(?, INTERVAL 6 DAY) AND TransferMoney>0 AND UserID=?";
            PreparedStatement pre = c.prepareStatement(sqlc);
            pre.setString(1, date);
            pre.setString(2, date);
            pre.setString(3, userID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public List<FinancialModel> getFinancialReportByDateToDateTransfer(String startDate, String endDate, String userID) {
        List<FinancialModel> models = new ArrayList<>();
        try {
            String sqlc = "SELECT * FROM tb_financial WHERE SaveDate BETWEEN ? AND ? AND TransferMoney>0  AND UserID=?";
            PreparedStatement pre = c.prepareStatement(sqlc);
            pre.setString(1, startDate);
            pre.setString(2, endDate);
            pre.setString(3, userID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public String getLastClass(int StudentID) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT MAX(FinancialID) AS MaxFinancialID,fn.RegisterID,rs.classID,className FROM tb_financial AS fn\n"
                    + "INNER JOIN tb_register AS rs ON fn.RegisterID=rs.registerID\n"
                    + "INNER JOIN tb_class AS cs ON rs.classID = cs.classID\n"
                    + "WHERE StudentID =?";
            pre = c.prepareStatement(sql);
            pre.setInt(1, StudentID);
            rs = pre.executeQuery();
            if (rs.next()) {
                if (rs.getString("className") == null) {
                    return "ນັກຮຽນໃໝ່";
                } else {
                    return rs.getString("className");
                }
            } else {
                return "ຜິດພາດຂໍ້ມູນ";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "ຜິດພາດຂໍ້ມູນ";
        } finally {
            try {
                pre.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public RegisterModel getLastRegister(int studentID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getPayMonth(int RegisterID, int StudentID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private FinancialModel resultModel(ResultSet rs) throws Exception {
        return new FinancialModel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12));
    }

    public static PreparedStatement setAutoPrepared(PreparedStatement pre, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pre.setObject(i + 1, params[i]);
        }
        return pre;
    }

    @Override
    public int getCountFinancial() {
        int count = 0;
        try {
            count = sql.getCount();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        }
        return count;
    }

    @Override
    public List<FinancialModel> getFinancialFree(int YearID) {
        List<FinancialModel> models = new ArrayList<>();
        try {
            String sqlc = "SELECT * FROM tb_financial\n"
                    + "INNER JOIN tb_register ON tb_financial.RegisterID=tb_register.registerID\n"
                    + "WHERE yearID=? GROUP BY StudentID";
            PreparedStatement pre = c.prepareStatement(sqlc);
            pre.setInt(1, YearID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(resultModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        }
        return models;
    }

}
