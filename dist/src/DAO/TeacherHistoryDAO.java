package DAO;

import DAOInterface.TeacherHistoryFn;
import Database.JoConnect;
import Model.TeacherHistoryModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TeacherHistoryDAO implements TeacherHistoryFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String SQL_Create = "INSERT INTO tb_teacherhistory VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_Update = "UPDATE tb_teacherhistory SET FamilyID = ?, PeopleID = ?, PassportID =?, SpouseName = ?, SpouseAge = ?, SpouseJob = ?, SpousePlace = ?, SpouseTel = ?, "
            + "FatherName = ?, FatherAge = ?, FatherJob = ?, FatherPlace =?, FatherTel = ?, "
            + "MotherName = ?, MotherAge = ?, MotherJob =?, MotherPlace = ?, MotherTel = ?, "
            + "BloodGroup = ?, DiverCategory = ?, DiverID = ?, Higth = ?, Weight = ? "
            + "WHERE TeacherHostoryID = ?";
    private final String SQL_Delete = "DELETE FROM tb_teacherhistory WHERE TeacherHostoryID=?";
    private final String SQL_GET_All = "SELECT * FROM tb_teacherhistory";
    private final String SQL_GET_ById = "SELECT * FROM tb_teacherhistory WHERE TeacherHostoryID =?";
    private final String SQL_GET_ByTeacherID = "SELECT * FROM tb_teacherhistory WHERE TeacherID =?";

    @Override
    public int CreaterTeacherHistory(TeacherHistoryModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Create);
            int i = 1;
            pre.setString(i++, null);
            pre.setInt(i++, model.getTeacherID());
            pre.setString(i++, model.getFamilyID());
            pre.setString(i++, model.getPeopleID());
            pre.setString(i++, model.getPassportID());
            pre.setString(i++, model.getSpouseName());
            pre.setInt(i++, model.getSpouseAge());
            pre.setString(i++, model.getSpouseJob());
            pre.setString(i++, model.getSpousePlace());
            pre.setString(i++, model.getSpouseTel());
            pre.setString(i++, model.getFatherName());
            pre.setInt(i++, model.getFatherAge());
            pre.setString(i++, model.getFatherJob());
            pre.setString(i++, model.getFatherPlace());
            pre.setString(i++, model.getFatherTel());
            pre.setString(i++, model.getMotherName());
            pre.setInt(i++, model.getMotherAge());
            pre.setString(i++, model.getMotherJob());
            pre.setString(i++, model.getMotherPlace());
            pre.setString(i++, model.getMotherTel());
            pre.setInt(i++, model.getBloodGroup());
            pre.setInt(i++, model.getDiverCategory());
            pre.setString(i++, model.getDiverID());
            pre.setInt(i++, model.getHigth());
            pre.setInt(i++, model.getWeight());
            return pre.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int UpdateTeacherHistory(TeacherHistoryModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Update);
            int i = 1;
            pre.setString(i++, model.getFamilyID());
            pre.setString(i++, model.getPeopleID());
            pre.setString(i++, model.getPassportID());
            pre.setString(i++, model.getSpouseName());
            pre.setInt(i++, model.getSpouseAge());
            pre.setString(i++, model.getSpouseJob());
            pre.setString(i++, model.getSpousePlace());
            pre.setString(i++, model.getSpouseTel());
            pre.setString(i++, model.getFatherName());
            pre.setInt(i++, model.getFatherAge());
            pre.setString(i++, model.getFatherJob());
            pre.setString(i++, model.getFatherPlace());
            pre.setString(i++, model.getFatherTel());
            pre.setString(i++, model.getMotherName());
            pre.setInt(i++, model.getMotherAge());
            pre.setString(i++, model.getMotherJob());
            pre.setString(i++, model.getMotherPlace());
            pre.setString(i++, model.getMotherTel());
            pre.setInt(i++, model.getBloodGroup());
            pre.setInt(i++, model.getDiverCategory());
            pre.setString(i++, model.getDiverID());
            pre.setInt(i++, model.getHigth());
            pre.setInt(i++, model.getWeight());
            pre.setInt(i++, model.getTeacherHostoryID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int DeleteTeacherHistory(TeacherHistoryModel model) {
        try {
            PreparedStatement pre=c.prepareStatement(SQL_Delete);
            pre.setInt(1, model.getTeacherHostoryID());
            return pre.executeUpdate();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<TeacherHistoryModel> getAllTeacherHistory() {
        List<TeacherHistoryModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int i = 1;
                TeacherHistoryModel model = new TeacherHistoryModel();
                model.setTeacherHostoryID(rs.getInt(i++));
                model.setTeacherID(rs.getInt(i++));
                model.setFamilyID(rs.getString(i++));
                model.setPeopleID(rs.getString(i++));
                model.setPassportID(rs.getString(i++));
                model.setSpouseName(rs.getString(i++));
                model.setSpouseAge(rs.getInt(i++));
                model.setSpouseJob(rs.getString(i++));
                model.setSpousePlace(rs.getString(i++));
                model.setSpouseTel(rs.getString(i++));
                model.setFatherName(rs.getString(i++));
                model.setFatherAge(rs.getInt(i++));
                model.setFatherJob(rs.getString(i++));
                model.setFatherPlace(rs.getString(i++));
                model.setFatherTel(rs.getString(i++));
                model.setMotherName(rs.getString(i++));
                model.setMotherAge(rs.getInt(i++));
                model.setMotherJob(rs.getString(i++));
                model.setMotherPlace(rs.getString(i++));
                model.setMotherTel(rs.getString(i++));
                model.setBloodGroup(rs.getInt(i++));
                model.setDiverCategory(rs.getInt(i++));
                model.setDiverID(rs.getString(i++));
                model.setHigth(rs.getInt(i++));
                model.setWeight(rs.getInt(i++));
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public TeacherHistoryModel getTeacherHistoryById(int TeacherHistoryID) {
        TeacherHistoryModel model = new TeacherHistoryModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ById);
            pre.setInt(1, TeacherHistoryID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int i = 1;
                model.setTeacherHostoryID(rs.getInt(i++));
                model.setTeacherID(rs.getInt(i++));
                model.setFamilyID(rs.getString(i++));
                model.setPeopleID(rs.getString(i++));
                model.setPassportID(rs.getString(i++));
                model.setSpouseName(rs.getString(i++));
                model.setSpouseAge(rs.getInt(i++));
                model.setSpouseJob(rs.getString(i++));
                model.setSpousePlace(rs.getString(i++));
                model.setSpouseTel(rs.getString(i++));
                model.setFatherName(rs.getString(i++));
                model.setFatherAge(rs.getInt(i++));
                model.setFatherJob(rs.getString(i++));
                model.setFatherPlace(rs.getString(i++));
                model.setFatherTel(rs.getString(i++));
                model.setMotherName(rs.getString(i++));
                model.setMotherAge(rs.getInt(i++));
                model.setMotherJob(rs.getString(i++));
                model.setMotherPlace(rs.getString(i++));
                model.setMotherTel(rs.getString(i++));
                model.setBloodGroup(rs.getInt(i++));
                model.setDiverCategory(rs.getInt(i++));
                model.setDiverID(rs.getString(i++));
                model.setHigth(rs.getInt(i++));
                model.setWeight(rs.getInt(i++));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

    @Override
    public TeacherHistoryModel getTeacherHistoryByTeacherId(int TeacherID) {
        TeacherHistoryModel model = new TeacherHistoryModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ByTeacherID);
            pre.setInt(1, TeacherID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int i = 1;
                model.setTeacherHostoryID(rs.getInt(i++));
                model.setTeacherID(rs.getInt(i++));
                model.setFamilyID(rs.getString(i++));
                model.setPeopleID(rs.getString(i++));
                model.setPassportID(rs.getString(i++));
                model.setSpouseName(rs.getString(i++));
                model.setSpouseAge(rs.getInt(i++));
                model.setSpouseJob(rs.getString(i++));
                model.setSpousePlace(rs.getString(i++));
                model.setSpouseTel(rs.getString(i++));
                model.setFatherName(rs.getString(i++));
                model.setFatherAge(rs.getInt(i++));
                model.setFatherJob(rs.getString(i++));
                model.setFatherPlace(rs.getString(i++));
                model.setFatherTel(rs.getString(i++));
                model.setMotherName(rs.getString(i++));
                model.setMotherAge(rs.getInt(i++));
                model.setMotherJob(rs.getString(i++));
                model.setMotherPlace(rs.getString(i++));
                model.setMotherTel(rs.getString(i++));
                model.setBloodGroup(rs.getInt(i++));
                model.setDiverCategory(rs.getInt(i++));
                model.setDiverID(rs.getString(i++));
                model.setHigth(rs.getInt(i++));
                model.setWeight(rs.getInt(i++));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }
}
