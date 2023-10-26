package DAO;

import DAOInterface.DAO;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.TeacherMoneyModel;
import Tools.JoAlert;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherMoneyDAO implements DAO<TeacherMoneyModel> {

    private String TableName = "tb_teachermoney";

    @Override
    public int create(TeacherMoneyModel data) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getCreate(),
                    data.getTeacherMoneyID(),
                    data.getTeacherID(),
                    data.getBalance(),
                    data.getSaveDate(),
                    data.getCode(),
                    data.getWithdraw(),
                    data.getDeposit(),
                    data.getComment(),
                    data.getUserID()
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
    public TeacherMoneyModel read(int id) {
        TeacherMoneyModel model = new TeacherMoneyModel();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectById(id);
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

    public TeacherMoneyModel readTeacherID(int id) {
        TeacherMoneyModel model = new TeacherMoneyModel();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getSelectCustom("teacherID=?");
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
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
    
    public List<TeacherMoneyModel> readAllTeacherID(int id) {
        List<TeacherMoneyModel> models = new  ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getSelectCustom("teacherID=? ORDER BY teacherMoneyID ASC");
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
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

    public TeacherMoneyModel getTeacherBalance(int teacherID) {
        JoConnect connect = new JoConnect();
        TeacherMoneyModel model = new TeacherMoneyModel();
        try {
            String sql = "SELECT * FROM tb_teachermoney WHERE teacherMoneyID = (SELECT MAX(teacherMoneyID) FROM tb_teachermoney WHERE teacherID = ?)";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, teacherID);
            ResultSet rs = pre.executeQuery();
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

    @Override
    public int update(TeacherMoneyModel data) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getUpdate(),
                    data.getTeacherID(),
                    data.getBalance(),
                    data.getSaveDate(),
                    data.getCode(),
                    data.getWithdraw(),
                    data.getDeposit(),
                    data.getComment(),
                    data.getUserID(),
                    data.getTeacherMoneyID()
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
    public int delete(int id) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, id);
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
    public List<TeacherMoneyModel> getAll() {
        List<TeacherMoneyModel> models = new ArrayList<>();
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
    public TeacherMoneyModel getResult(ResultSet rs) throws Exception {
        return new TeacherMoneyModel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
    }

}
