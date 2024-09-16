package DAO;

import DAOInterface.StudentHistoryFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.ChartParentJobModel;
import Model.StudentHistoryModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentHistoryDAO implements StudentHistoryFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_studenthistory";

    @Override
    public int CreaterStudentHistory(StudentHistoryModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getCreate(),
                    null,
                    model.getStudentID(),
                    model.getFamilyID(),
                    model.getPeopleID(),
                    model.getPassportID(),
                    model.getSiblingName(),
                    model.getSiblingAge(),
                    model.getSiblingJob(),
                    model.getSiblingPlace(),
                    model.getSiblingTel(),
                    model.getHigth(),
                    model.getWeight(),
                    model.getFatherName(),
                    model.getFatherAge(),
                    model.getFatherJob(),
                    model.getFatherPlace(),
                    model.getFatherTel(),
                    model.getMotherName(),
                    model.getMotherAge(),
                    model.getMotherJob(),
                    model.getMotherPlace(),
                    model.getMotherTel(),
                    model.getBloodGroup(),
                    model.getDiverCategory(),
                    model.getParent1(),
                    model.getParent2()
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
    public int UpdateStudentHistory(StudentHistoryModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);

        try {
            PreparedStatement pre = sql.setPrepared(sql.getUpdate(),
                    model.getStudentID(),
                    model.getFamilyID(),
                    model.getPeopleID(),
                    model.getPassportID(),
                    model.getSiblingName(),
                    model.getSiblingAge(),
                    model.getSiblingJob(),
                    model.getSiblingPlace(),
                    model.getSiblingTel(),
                    model.getHigth(),
                    model.getWeight(),
                    model.getFatherName(),
                    model.getFatherAge(),
                    model.getFatherJob(),
                    model.getFatherPlace(),
                    model.getFatherTel(),
                    model.getMotherName(),
                    model.getMotherAge(),
                    model.getMotherJob(),
                    model.getMotherPlace(),
                    model.getMotherTel(),
                    model.getBloodGroup(),
                    model.getDiverCategory(),
                    model.getParent1(),
                    model.getParent2(),
                    model.getHistroyID()
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
    public int DeleteStudentHistory(StudentHistoryModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getHistroyID());
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
    public List<StudentHistoryModel> getAllStudentHistory() {
        List<StudentHistoryModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(getResult(rs));
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
    public StudentHistoryModel getStudentHistoryByStudentID(int StudentID) {
        StudentHistoryModel model = new StudentHistoryModel();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectByIndex(2, StudentID);
            if (rs.next()) {
                model = getResult(rs);
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

    private StudentHistoryModel getResult(ResultSet rs) throws Exception {
        return new StudentHistoryModel(
                rs.getInt(1),
                rs.getInt(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getInt(7),
                rs.getString(8),
                rs.getString(9),
                rs.getString(10),
                rs.getInt(11),
                rs.getInt(12),
                rs.getString(13),
                rs.getInt(14),
                rs.getString(15),
                rs.getString(16),
                rs.getString(17),
                rs.getString(18),
                rs.getInt(19),
                rs.getString(20),
                rs.getString(21),
                rs.getString(22),
                rs.getInt(23),
                rs.getInt(24),
                rs.getString(25),
                rs.getString(25),
                rs.getString(26));
    }

    public List<ChartParentJobModel> getChartJobs(String parentCol) {
        List<ChartParentJobModel> jobModels = new ArrayList<>();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT "+parentCol+", COUNT(*)as jobcount FROM tb_studenthistory GROUP BY "+parentCol+" ORDER BY jobcount DESC";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                jobModels.add(new ChartParentJobModel(rs.getString(1), rs.getInt(2)));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return jobModels;
    }

}
