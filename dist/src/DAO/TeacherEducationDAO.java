package DAO;

import DAOInterface.TeacherEducationFn;
import Database.JoConnect;
import Model.TeacherAddressModel;
import Model.TeacherEducationModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TeacherEducationDAO implements TeacherEducationFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String SQL_Create = "INSERT INTO tb_teachereducation VALUES(?,?,?,?,?,?)";
    private final String SQL_Update = "UPDATE tb_teachereducation SET educationCat=?,MajorName=?,InstitutionName=?,graduatDate=? WHERE TeacherEducationID=?";
    private final String SQL_Delete = "DELETE FROM tb_teachereducation WHERE TeacherEducationID =?";
    private final String SQL_GET_ById = "SELECT * FROM tb_teachereducation WHERE TeacherEducationID=?";
    private final String SQL_GET_ALLByTeacherID = "SELECT * FROM tb_teachereducation WHERE TeacherID=?";

    @Override
    public int CreaterTeacherEducation(TeacherEducationModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Create);
            pre.setString(1, null);
            pre.setInt(2, model.getTeacherID());
            pre.setInt(3, model.getEducationCat());
            pre.setString(4, model.getMajorName());
            pre.setString(5, model.getInstitutionName());
            pre.setDate(6, model.getGraduatDate());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateTeacherEducation(TeacherEducationModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Update);
            int i = 1;
            pre.setInt(i++, model.getEducationCat());
            pre.setString(i++, model.getMajorName());
            pre.setString(i++, model.getInstitutionName());
            pre.setDate(i++, model.getGraduatDate());
            pre.setInt(i++, model.getTeacherEducationID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int DeleteTeacherEducation(TeacherEducationModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Delete);
            pre.setInt(1, model.getTeacherEducationID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public List<TeacherEducationModel> getALLByTeacherID(int TeacherID) {
        List<TeacherEducationModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ALLByTeacherID);
            pre.setInt(1, TeacherID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                TeacherEducationModel model = new TeacherEducationModel();
                model.setTeacherEducationID(rs.getInt(1));
                model.setTeacherID(rs.getInt(2));
                model.setEducationCat(rs.getInt(3));
                model.setMajorName(rs.getString(4));
                model.setInstitutionName(rs.getString(5));
                model.setGraduatDate(rs.getDate(6));
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public TeacherEducationModel getTeacherEducationById(int TeacherEducationID) {
        TeacherEducationModel model = new TeacherEducationModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ById);
            pre.setInt(1, TeacherEducationID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                model.setTeacherEducationID(rs.getInt(1));
                model.setTeacherID(rs.getInt(2));
                model.setEducationCat(rs.getInt(3));
                model.setMajorName(rs.getString(4));
                model.setInstitutionName(rs.getString(5));
                model.setGraduatDate(rs.getDate(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

}
