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
import java.util.ArrayList;

//import java.sql.Statement;
public class UserDAO implements DAOInterface.UserFn {
    
    private final Connection c = new JoConnect().getConnectionDefault();
    private final String SQL_Create_User = "INSERT INTO tb_user VALUES(?,?,?,?,?,?)";
    private final String SQL_Update_User = "UPDATE tb_user SET tid=?,username=?,password=?,userlog=?,userdate=? WHERE uid=?";
    private final String SQL_Delete_User = "DELETE FROM tb_user WHERE uid=?";
    private final String SQL_GET_All_User = "SELECT * FROM tb_user";
    private final String SQL_GET_ById_User = "SELECT * FROM tb_user WHERE uid=?";
    private final String SQL_Login_User = "SELECT * FROM tb_user WHERE username=? AND password=?";
    private final JoSQL sql = new JoSQL(c, "tb_user");
    
    @Override
    public int CreateUser(UserModel userModel) {
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
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return 0;
        }
    }
    
    @Override
    public int UpdateUser(UserModel userModel) {
        System.out.println("U: " + userModel);
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
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return 0;
        }
    }
    
    @Override
    public int DeleteUser(UserModel userModel) {
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, userModel.getUserID());
            return pre.executeUpdate();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
            return 0;
        }
    }
    
    @Override
    public List<UserModel> getUserAll() {
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
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        }
        return models;
    }
    
    @Override
    public UserModel getUserById(int UserID) {
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
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        }
        return model;
    }
    
    @Override
    public UserModel UserLogin(String User, String Password) {
        UserModel model = new UserModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Login_User);
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
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        }
        return model;
    }
    
    @Override
    public int UpdateUserLogTime(UserModel userModel) {
        try {
            PreparedStatement pre = sql.getUpdateByColumns(new String[]{"userlog", "userdate"});
            pre.setString(1, userModel.getUserLog());
            pre.setDate(2, userModel.getDate());
            pre.setInt(3, userModel.getUserID());
            return pre.executeUpdate();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
            return 0;
        }
    }
    
    @Override
    public UserModel getUserByAuthenKey(String authenKey) {
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
            
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        }
        return model;
    }
    
}
