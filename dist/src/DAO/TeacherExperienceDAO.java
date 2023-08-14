package DAO;

import DAOInterface.TeacherEducationFn;
import DAOInterface.TeacherExperienceFn;
import Database.JoConnect;
import Model.TeacherEducationModel;
import Model.TeacherExperienceModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TeacherExperienceDAO implements TeacherExperienceFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String SQL_Create = "INSERT INTO tb_teacherexperience VALUES(?,?,?,?,?,?,?)";
    private final String SQL_Update = "UPDATE tb_teacherexperience SET ExperienceName=?,ExperiencePlace=?,ExperienceInfo=?,ExperienceDateStart=?,ExperienceDateStop=? WHERE ExperienceID =?";
    private final String SQL_Delete = "DELETE FROM tb_teacherexperience WHERE ExperienceID=?";
    private final String SQL_GET_All_ByTeacherID = "SELECT * FROM tb_teacherexperience WHERE TeacherID=?";
    private final String SQL_GET_ById = "SELECT * FROM tb_teacherexperience WHERE ExperienceID=?";
    private final String SQL_GET_BetweenYear = "SELECT * FROM tb_teacherexperience WHERE TeacherID = ? AND ExperienceDateStart BETWEEN ? AND ?";

    @Override
    public int CreaterExperience(TeacherExperienceModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Create);
            int i = 1;
            pre.setString(i++, null);
            pre.setInt(i++, model.getTeacherID());
            pre.setString(i++, model.getExperienceName());
            pre.setString(i++, model.getExperiencePlace());
            pre.setString(i++, model.getExperienceInfo());
            pre.setDate(i++, model.getExperienceDateStart());
            pre.setDate(i++, model.getExperienceDateStop());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateExperience(TeacherExperienceModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Update);
            int i = 1;
            pre.setString(i++, model.getExperienceName());
            pre.setString(i++, model.getExperiencePlace());
            pre.setString(i++, model.getExperienceInfo());
            pre.setDate(i++, model.getExperienceDateStart());
            pre.setDate(i++, model.getExperienceDateStop());
            pre.setInt(i++, model.getExperienceID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int DeleteExperience(TeacherExperienceModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Delete);
            pre.setInt(1, model.getExperienceID());
            return pre.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<TeacherExperienceModel> getAllExperienceByTeacherID(int TeacherID) {
        List<TeacherExperienceModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All_ByTeacherID);
            pre.setInt(1, TeacherID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                TeacherExperienceModel model = new TeacherExperienceModel();
                model.setExperienceID(rs.getInt(1));
                model.setTeacherID(rs.getInt(2));
                model.setExperienceName(rs.getString(3));
                model.setExperiencePlace(rs.getString(4));
                model.setExperienceInfo(rs.getString(5));
                model.setExperienceDateStart(rs.getDate(6));
                model.setExperienceDateStop(rs.getDate(7));
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public TeacherExperienceModel getExperienceById(int ExperienceID) {
        TeacherExperienceModel model = new TeacherExperienceModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ById);
            pre.setInt(1, ExperienceID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                model.setExperienceID(rs.getInt(1));
                model.setTeacherID(rs.getInt(2));
                model.setExperienceName(rs.getString(3));
                model.setExperiencePlace(rs.getString(4));
                model.setExperienceInfo(rs.getString(5));
                model.setExperienceDateStart(rs.getDate(6));
                model.setExperienceDateStop(rs.getDate(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

    @Override
    public List<TeacherExperienceModel> getExperienceBetweenYear(int TeacherID, String YearName) {
        String yearRange = YearName;
        String[] years = yearRange.split("-");
        String yearStart = years[0] + "-01-01"; // "2021-01-01"
        String yearEnd = years[1] + "-12-31"; // "2022-12-31"
        List<TeacherExperienceModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_BetweenYear);
            pre.setInt(1, TeacherID);
            pre.setString(2, yearStart);
            pre.setString(3, yearEnd);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(new TeacherExperienceModel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDate(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

}
