package DAO;

import DAOInterface.RegisterFn;
import DAOSevervice.YearService;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Log.querylog;
import Model.GlobalDataModel;
import Model.RegisterModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterDAO implements RegisterFn {

    private final String TableName = "tb_register";

    @Override
    public int Creater(RegisterModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            try (PreparedStatement pre = getPrepareStatement(sql.getCreate(),
                    model.getRegisterID(),
                    model.getClassRoomName(),
                    model.getYearID(),
                    model.getClassID(),
                    model.getRegisterDate()
            )) {
                return pre.executeUpdate();
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            GlobalDataModel.registerModels = getRegisterLastYearAll();
            connect.close();
        }
    }

    @Override
    public int Update(RegisterModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            try (PreparedStatement pre = getPrepareStatement(sql.getUpdate(),
                    model.getClassRoomName(),
                    model.getYearID(),
                    model.getClassID(),
                    model.getRegisterDate(),
                    model.getRegisterID()
            )) {
                return pre.executeUpdate();
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            GlobalDataModel.registerModels = getRegisterLastYearAll();
            connect.close();
        }
    }

    @Override
    public int Delete(int ID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            try (PreparedStatement pre = sql.getDelete()) {
                pre.setInt(1, ID);
                querylog.saveQueryLog(pre.toString(), this);
                return pre.executeUpdate();
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            GlobalDataModel.registerModels = getRegisterLastYearAll();
            connect.close();
        }
    }

    @Override
    public List<RegisterModel> getRegisterAll() {
        JoConnect connect = new JoConnect();
        List<RegisterModel> models = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_register ORDER BY classID ASC";
            Statement statement = connect.getConnectionDefault().createStatement();
            try (ResultSet rs = statement.executeQuery(sql)) {
                while (rs.next()) {
                    models.add(getResult(rs));
                }
                statement.cancel();
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public List<RegisterModel> getRegisterLastYearAll() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<RegisterModel> models = new ArrayList<>();
        YearService yearService = new YearService();
        try {
            int lastYearID = yearService.getLastYear().getYearID();
            PreparedStatement pre = sql.getSelectCustom("yearID=? ORDER BY classID ASC");
            pre.setInt(1, lastYearID);
            ResultSet rs = pre.executeQuery();
            if (!rs.next()) {
                pre.setInt(1, lastYearID - 1);
                rs = pre.executeQuery();
            } else {
                rs.beforeFirst();
            }
            while (rs.next()) {
                models.add(getResult(rs));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public RegisterModel getRegisterById(int ID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        RegisterModel model = new RegisterModel();
        try {
            try (ResultSet rs = sql.getSelectById(ID)) {
                if (rs.next()) {
                    model = getResult(rs);
                }
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

    @Override
    public int getCountRegister() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        int count = 0;
        try {
            count = sql.getCount();
        } catch (Exception e) {
            JoLoger.saveLog(e, count);
            JoAlert.Error(e, count);
        } finally {
            connect.close();
        }
        return count;
    }

    @Override
    public boolean getCheckClassRegister(int classID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs;
            try (PreparedStatement pre = sql.getSelectCustom("classID=?")) {
                pre.setInt(1, classID);
                rs = pre.executeQuery();
            }
            return rs.next();
        } catch (SQLException e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
            return false;
        } finally {
            connect.close();
        }
    }

    private RegisterModel getResult(ResultSet rs) throws SQLException {
        return new RegisterModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
    }

    private PreparedStatement getPrepareStatement(PreparedStatement pre, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pre.setObject(i + 1, params[i]);
        }
        return pre;
    }

    @Override
    public List<RegisterModel> getRegisterAllByYearID(int YearID) {
        List<RegisterModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getSelectCustom("yearID=? ORDER BY classID ASC");
            pre.setInt(1, YearID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(getResult(rs));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    public List<RegisterModel> getRegisterByYear_Class(int YearID, int ClassID) {
        List<RegisterModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT * FROM tb_register\n"
                    + "WHERE yearID=? AND classID=?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, YearID);
            pre.setInt(2, ClassID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(getResult(rs));
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

}
