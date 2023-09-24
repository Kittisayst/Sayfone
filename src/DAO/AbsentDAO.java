package DAO;

import DAOInterface.DAO;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.AbsentModel;
import Tools.JoAlert;
import java.sql.ResultSet;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class AbsentDAO implements DAO<AbsentModel> {

    private final String TableName = "tb_absent";

    @Override
    public int create(AbsentModel data) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getCreate(), data.getAbsentID(), data.getRegisterID(), data.getAbsentDate(), data.getAbsentData(), data.getUserID());
            return pre.executeUpdate();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public AbsentModel read(int id) {
        AbsentModel model = new AbsentModel();
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

    public List<AbsentModel> readByRegisterID(int registerID) {
        List<AbsentModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getSelectCustom("RegisterID=? ORDER BY absentID DESC");
            pre.setInt(1, registerID);
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

    public List<AbsentModel> searchByDate(Date date) {
        List<AbsentModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getSelectCustom("absentDate=? ORDER BY absentID DESC");
            pre.setDate(1, date);
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

    @Override
    public int update(AbsentModel data) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getUpdate(), data.getRegisterID(), data.getAbsentDate(), data.getAbsentData(), data.getUserID(), data.getAbsentID());
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
    public List<AbsentModel> getAll() {
        List<AbsentModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectAll(JoSQL.ORDER.DESC);
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
    public AbsentModel getResult(ResultSet rs) throws Exception {
        return new AbsentModel(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getInt(5));
    }
}
