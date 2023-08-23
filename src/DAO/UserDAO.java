package DAO;

import DAOSevervice.TeacherService;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.TeacherModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.UserModel;
import Utility.JoPrepared;
import java.sql.SQLException;
import java.util.ArrayList;

//import java.sql.Statement;
public class UserDAO implements DAOInterface.UserFn {

    private final String SQL_Login_User = "SELECT * FROM tb_user WHERE username=? AND password=?";
    private String TableName = "tb_user";

    @Override
    public int CreateUser(UserModel userModel) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getCreate();
            int i = 1;
            pre.setString(i++, null);
            pre.setInt(i++, userModel.getTeacherID());
            pre.setString(i++, userModel.getUserName());
            pre.setString(i++, userModel.getPassword());
            pre.setString(i++, userModel.getUserLog());
            pre.setDate(i++, userModel.getDate());
            pre.setString(i++, userModel.getAuthenKey());
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
    public int UpdateUser(UserModel userModel) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            JoPrepared prepared = new JoPrepared();
            PreparedStatement pre = prepared.setAutoPrepared(sql.getUpdate(),
                    userModel.getTeacherID(),
                    userModel.getUserName(),
                    userModel.getPassword(),
                    userModel.getUserLog(),
                    userModel.getDate(),
                    userModel.getAuthenKey(),
                    userModel.getUserID());
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
    public int DeleteUser(UserModel userModel) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, userModel.getUserID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public List<UserModel> getUserAll() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<UserModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                UserModel model = new UserModel();
                model.setUserID(rs.getInt(1));
                model.setTeacherID(rs.getInt(2));
                model.setUserName(rs.getString(3));
                model.setPassword(rs.getString(4));
                model.setUserLog(rs.getString(5));
                model.setDate(rs.getDate(6));
                model.setAuthenKey(rs.getString(7));
                TeacherService teacherService = new TeacherService();
                TeacherModel teacherModel = teacherService.getTeacherById(rs.getInt(2));
                model.setName(teacherModel.getName());
                model.setGender(teacherModel.getGender());
                models.add(model);
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
    public UserModel getUserById(int UserID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        UserModel model = new UserModel();
        try {
            ResultSet rs = sql.getSelectById(UserID);
            if (rs.next()) {
                model.setUserID(rs.getInt(1));
                model.setUserName(rs.getString(3));
                model.setPassword(rs.getString(4));
                model.setUserLog(rs.getString(5));
                model.setDate(rs.getDate(6));
                model.setAuthenKey(rs.getString(7));
                TeacherService service = new TeacherService();
                TeacherModel teacherModel = service.getTeacherById(rs.getInt(2));
                model.setTeacherID(rs.getInt(2));
                model.setGender(teacherModel.getGender());
                model.setName(teacherModel.getName());
                model.setNameENG(teacherModel.getNameENG());
            }
        } catch (SQLException e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

    @Override
    public UserModel UserLogin(String User, String Password) {
        JoConnect connect = new JoConnect();
        UserModel model = new UserModel();
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(SQL_Login_User);
            pre.setString(1, User);
            pre.setString(2, Password);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                model.setUserID(rs.getInt(1));
                model.setTeacherID(rs.getInt(2));
                model.setUserName(rs.getString(3));
                model.setPassword(rs.getString(4));
                model.setUserLog(rs.getString(5));
                model.setDate(rs.getDate(6));
                model.setAuthenKey(rs.getString(7));
                TeacherService service = new TeacherService();
                TeacherModel teacherModel = service.getTeacherById(model.getTeacherID());
                model.setGender(teacherModel.getGender());
                model.setName(teacherModel.getName());
            }
        } catch (SQLException e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

    @Override
    public int UpdateUserLogTime(UserModel userModel) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getUpdateByColumns(new String[]{"userlog", "userdate"});
            pre.setString(1, userModel.getUserLog());
            pre.setDate(2, userModel.getDate());
            pre.setInt(3, userModel.getUserID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public UserModel getUserByAuthenKey(String authenKey) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        UserModel model = new UserModel();
        try {
            ResultSet rs = sql.getSelectByIndex(7, authenKey);
            if (rs.next()) {
                model = new UserModel(
                        rs.getInt(1),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7));
                model.setTeacherID(rs.getInt(2));
                model.setName(new TeacherService().getTeacherById(rs.getInt(2)).getName());
            }

        } catch (SQLException e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

}
