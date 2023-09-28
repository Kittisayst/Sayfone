package DAO;

import DAOInterface.DAO;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.PermissionModel;
import Tools.JoAlert;
import java.sql.ResultSet;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class PermissionDAO implements DAO<PermissionModel> {

    private final String TableName = "tb_permissions";

    @Override
    public int create(PermissionModel data) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getCreate(), data.getPermissionID(), data.getUserID(), data.getType(), data.isState());
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
    public PermissionModel read(int id) {
        PermissionModel model = new PermissionModel();
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

    @Override
    public int update(PermissionModel data) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getUpdate(), data.getUserID(), data.getType(), data.isState(), data.getPermissionID());
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
    public List<PermissionModel> getAll() {
        List<PermissionModel> models = new ArrayList<>();
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

    public PermissionModel getRole(int UserID, int Type) {
        PermissionModel model = new PermissionModel();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getSelectCustom("UserID=? AND type=?");
            pre.setInt(1, UserID);
            pre.setInt(2, Type);
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
    public PermissionModel getResult(ResultSet rs) throws Exception {
        return new PermissionModel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4));
    }

}
