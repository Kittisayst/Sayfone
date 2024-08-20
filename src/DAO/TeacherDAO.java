package DAO;

import Model.TeacherModel;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Tools.JoAlert;
import Utility.JoBlobConvert;
import java.io.InputStream;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDAO implements DAOInterface.TeacherFn {

    private final String TableName = "tb_teacher";
    private final String SQL_Update = "UPDATE tb_teacher SET NationalityID=?,EthnicID=?,ReligionID=?,ClassID=?,TeacherNo=?,Name=?,NameENG=?,NickName=?,Gender=?,DateOfBirth=?,"
            + " Tel=?,Email=?,Facebook=?,DateStart=?,DateStop=?,Talent=?,Health=?,Status=? WHERE TeacherID=?";
    private final String SQL_GET_LAST_ID = "SELECT MAX(TeacherID) AS ID FROM tb_teacher";
    private final String SQL_Update_Image = "UPDATE tb_teacher SET Image=? WHERE TeacherID=?";
    private final String SQL_Count_Gender = "SELECT COUNT(TeacherID) AS GenderCount FROM tb_teacher WHERE Gender=0";

    @Override
    public int CreateTeacher(TeacherModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            int i = 1;
            PreparedStatement pre = sql.getCreate();
            pre.setString(i++, null);
            pre.setInt(i++, model.getNationalityID());
            pre.setInt(i++, model.getEthnicID());
            pre.setInt(i++, model.getReligionID());
            pre.setInt(i++, model.getClassID());
            pre.setString(i++, model.getTeacherNo());
            pre.setString(i++, model.getName());
            pre.setString(i++, model.getNameENG());
            pre.setString(i++, model.getNickName());
            pre.setInt(i++, model.getGender());
            pre.setDate(i++, model.getDateOfBirth());
            pre.setString(i++, model.getTel());
            pre.setString(i++, model.getEmail());
            pre.setString(i++, model.getFacebook());
            pre.setDate(i++, model.getDateStart());
            pre.setDate(i++, model.getDateStop());
            pre.setString(i++, model.getTalent());
            if (model.getImageFile() == null) {
                pre.setString(i++, null);
            } else {
                InputStream in = new JoBlobConvert(model.getImageFile()).getFileInput();
                pre.setBinaryStream(i++, in, in.available());
            }
            pre.setInt(i++, model.getHealth());
            pre.setInt(i++, model.getStatus());
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
    public int UpdateTeacher(TeacherModel model) {
        JoConnect connect = new JoConnect();
        try {
            int i = 1;
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(SQL_Update);
            pre.setInt(i++, model.getNationalityID());
            pre.setInt(i++, model.getEthnicID());
            pre.setInt(i++, model.getReligionID());
            pre.setInt(i++, model.getClassID());
            pre.setString(i++, model.getTeacherNo());
            pre.setString(i++, model.getName());
            pre.setString(i++, model.getNameENG());
            pre.setString(i++, model.getNickName());
            pre.setInt(i++, model.getGender());
            pre.setDate(i++, model.getDateOfBirth());
            pre.setString(i++, model.getTel());
            pre.setString(i++, model.getEmail());
            pre.setString(i++, model.getFacebook());
            pre.setDate(i++, model.getDateStart());
            pre.setDate(i++, model.getDateStop());
            pre.setString(i++, model.getTalent());
            if (model.getImageFile() != null) {
                UpdateImage(model);
            }
            pre.setInt(i++, model.getHealth());
            pre.setInt(i++, model.getStatus());
            pre.setInt(i++, model.getTeacherID());
            return pre.executeUpdate();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    private void UpdateImage(TeacherModel model) {
        JoConnect connect = new JoConnect();
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(SQL_Update_Image);
            InputStream in = new JoBlobConvert(model.getImageFile()).getFileInput();
            pre.setBinaryStream(1, in, in.available());
            pre.setInt(2, model.getTeacherID());
            pre.executeUpdate();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
    }

    @Override
    public int DeleteTeacher(TeacherModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getTeacherID());
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
    public TeacherModel getTeacherById(int teacherID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        TeacherModel model = new TeacherModel();
        try {
            ResultSet rs = sql.getSelectById(teacherID);
            int i = 1;
            if (rs.next()) {
                model.setTeacherID(rs.getInt(i++));
                model.setNationalityID(rs.getInt(i++));
                model.setEthnicID(rs.getInt(i++));
                model.setReligionID(rs.getInt(i++));
                model.setClassID(rs.getInt(i++));
                model.setTeacherNo(rs.getString(i++));
                model.setName(rs.getString(i++));
                model.setNameENG(rs.getString(i++));
                model.setNickName(rs.getString(i++));
                model.setGender(rs.getInt(i++));
                model.setDateOfBirth(rs.getDate(i++));
                model.setTel(rs.getString(i++));
                model.setEmail(rs.getString(i++));
                model.setFacebook(rs.getString(i++));
                model.setDateStart(rs.getDate(i++));
                model.setDateStop(rs.getDate(i++));
                model.setTalent(rs.getString(i++));
                model.setImage(rs.getBlob(i++));
                model.setHealth(rs.getInt(i++));
                model.setStatus(rs.getInt(i++));
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
    public List<TeacherModel> getAllTeacher() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<TeacherModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                int i = 1;
                TeacherModel model = new TeacherModel();
                model.setTeacherID(rs.getInt(i++));
                model.setNationalityID(rs.getInt(i++));
                model.setEthnicID(rs.getInt(i++));
                model.setReligionID(rs.getInt(i++));
                model.setClassID(rs.getInt(i++));
                model.setTeacherNo(rs.getString(i++));
                model.setName(rs.getString(i++));
                model.setNameENG(rs.getString(i++));
                model.setNickName(rs.getString(i++));
                model.setGender(rs.getInt(i++));
                model.setDateOfBirth(rs.getDate(i++));
                model.setTel(rs.getString(i++));
                model.setEmail(rs.getString(i++));
                model.setFacebook(rs.getString(i++));
                model.setDateStart(rs.getDate(i++));
                model.setDateStop(rs.getDate(i++));
                model.setTalent(rs.getString(i++));
                model.setImage(rs.getBlob(i++));
                model.setHealth(rs.getInt(i++));
                model.setStatus(rs.getInt(i++));
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
    public int getLastTeacherID() {
        JoConnect connect = new JoConnect();
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(SQL_GET_LAST_ID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public int getGenderCount() {
        JoConnect connect = new JoConnect();
        int Count = 0;
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(SQL_Count_Gender);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Count = rs.getInt(1);
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return Count;
    }

    @Override
    public int getTeacherCount() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        int Count = 0;
        try {
            Count = sql.getCount();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return Count;
    }

    public boolean getTeacherinFinancial(int teacherID) {
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT UserID FROM tb_financial AS f\n"
                    + "INNER JOIN tb_user AS u ON f.UserID = u.uid\n"
                    + "INNER JOIN tb_teacher AS t ON u.tid = t.TeacherID\n"
                    + "WHERE u.tid=? LIMIT 1";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setInt(1, teacherID);
//            System.out.println(pre);
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

}
