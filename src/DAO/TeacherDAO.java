package DAO;

import Model.TeacherModel;
import Database.JoConnect;
import Tools.JoAlert;
import Utility.JoBlobConvert;
import java.io.InputStream;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TeacherDAO implements DAOInterface.TeacherFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String SQL_Create = "INSERT INTO tb_teacher VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_Update = "UPDATE tb_teacher SET NationalityID=?,EthnicID=?,ReligionID=?,ClassID=?,TeacherNo=?,Name=?,NameENG=?,NickName=?,Gender=?,DateOfBirth=?,"
            + " Tel=?,Email=?,Facebook=?,DateStart=?,DateStop=?,Talent=?,Health=?,Status=? WHERE TeacherID=?";
    private final String SQL_Delete= "DELETE FROM tb_teacher WHERE TeacherID=?";
    private final String SQL_GET_All_Teacher = "SELECT * FROM tb_teacher";
    private final String SQL_GET_ById_Teacher = "SELECT * FROM tb_teacher WHERE TeacherID=?";
    private final String SQL_Login_User = "SELECT * FROM tb_user WHERE username=? AND password=?";
    private final String SQL_GET_LAST_ID = "SELECT MAX(TeacherID) AS ID FROM tb_teacher";
    private final String SQL_Update_Image = "UPDATE tb_teacher SET Image=? WHERE TeacherID=?";
    private final String SQL_Count_Gender = "SELECT COUNT(TeacherID) AS GenderCount FROM tb_teacher WHERE Gender=0";
    private final String SQL_Count="SELECT COUNT(TeacherID) AS TeacherCount FROM tb_teacher";

    @Override
    public int CreateTeacher(TeacherModel model) {
        
        try {
            int i = 1;
            PreparedStatement pre = c.prepareStatement(SQL_Create);
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
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateTeacher(TeacherModel model) {
        try {
            int i = 1;
            PreparedStatement pre = c.prepareStatement(SQL_Update);
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
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    private void UpdateImage(TeacherModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Update_Image);
            InputStream in = new JoBlobConvert(model.getImageFile()).getFileInput();
            pre.setBinaryStream(1, in, in.available());
            pre.setInt(2, model.getTeacherID());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
    }

    @Override
    public int DeleteTeacher(TeacherModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Delete);
            pre.setInt(1, model.getTeacherID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public TeacherModel getTeacherById(int teacherID) {
        TeacherModel model = new TeacherModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ById_Teacher);
            pre.setInt(1, teacherID);
            ResultSet rs = pre.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

    @Override
    public List<TeacherModel> getAllTeacher() {
        List<TeacherModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All_Teacher);
            ResultSet rs = pre.executeQuery();
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
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public int getLastTeacherID() {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_LAST_ID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int getGenderCount() {
        int Count = 0;
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Count_Gender);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return Count;
    }

    @Override
    public int getTeacherCount() {
         int Count = 0;
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Count);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return Count;
    }

}
