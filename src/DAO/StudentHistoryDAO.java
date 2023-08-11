package DAO;

import DAOInterface.StudentHistoryFn;
import Database.JoConnect;
import Model.StudentHistoryModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentHistoryDAO implements StudentHistoryFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_studenthistory";
    private final String SQL_Create = "INSERT INTO " + TableName + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_Update = "UPDATE " + TableName + " SET FamilyID=?,PeopleID=?,PassportID=?,SiblingName=?,"
            + "SiblingAge=?,SiblingJob=?,SiblingPlace=?,SiblingTel=?,Higth=?,Weight=?,FatherName=?,FatherAge=?,"
            + "FatherJob=?,FatherPlace=?,FatherTel=?,MotherName=?,MotherAge=?,MotherJob=?,"
            + "MotherPlace=?,MotherTel=?,BloodGroup=?,DiverCategory=? WHERE SHistroyID=?";
    private final String SQL_Delete = "DELETE FROM " + TableName + " WHERE SHistroyID=?";
    private final String SQL_GET_All = "SELECT * FROM " + TableName;
    private final String SQL_GET_ByStudentID = "SELECT * FROM " + TableName + " WHERE StudentID=?";

    @Override
    public int CreaterStudentHistory(StudentHistoryModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Create);
            int i = 1;
            pre.setString(i++, null);
            pre.setInt(i++, model.getStudentID());
            pre.setString(i++, model.getFamilyID());
            pre.setString(i++, model.getPeopleID());
            pre.setString(i++, model.getPassportID());
            pre.setString(i++, model.getSiblingName());
            pre.setInt(i++, model.getSiblingAge());
            pre.setString(i++, model.getSiblingJob());
            pre.setString(i++, model.getSiblingPlace());
            pre.setString(i++, model.getSiblingTel());
            pre.setInt(i++, model.getHigth());
            pre.setInt(i++, model.getWeight());
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
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateStudentHistory(StudentHistoryModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Update);
            int i = 1;
            pre.setString(i++, model.getFamilyID());
            pre.setString(i++, model.getPeopleID());
            pre.setString(i++, model.getPassportID());
            pre.setString(i++, model.getSiblingName());
            pre.setInt(i++, model.getSiblingAge());
            pre.setString(i++, model.getSiblingJob());
            pre.setString(i++, model.getSiblingPlace());
            pre.setString(i++, model.getSiblingTel());
            pre.setInt(i++, model.getHigth());
            pre.setInt(i++, model.getWeight());
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
            pre.setInt(i++, model.getHistroyID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int DeleteStudentHistory(StudentHistoryModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Delete);
            pre.setInt(1, model.getStudentID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<StudentHistoryModel> getAllStudentHistory() {
        List<StudentHistoryModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int i = 1;
                StudentHistoryModel model = new StudentHistoryModel();
                model.setHistroyID(rs.getInt(i++));
                model.setStudentID(rs.getInt(i++));
                model.setFamilyID(rs.getString(i++));
                model.setPeopleID(rs.getString(i++));
                model.setPassportID(rs.getString(i++));

                model.setSiblingName(rs.getString(i++));
                model.setSiblingAge(rs.getInt(i++));
                model.setSiblingJob(rs.getString(i++));
                model.setSiblingPlace(rs.getString(i++));
                model.setSiblingTel(rs.getString(i++));

                model.setHigth(rs.getInt(i++));
                model.setWeight(rs.getInt(i++));

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
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public StudentHistoryModel getStudentHistoryByStudentID(int StudentID) {
        StudentHistoryModel model = new StudentHistoryModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ByStudentID);
            pre.setInt(1, StudentID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int i = 1;
                model.setHistroyID(rs.getInt(i++));
                model.setStudentID(rs.getInt(i++));
                model.setFamilyID(rs.getString(i++));
                model.setPeopleID(rs.getString(i++));
                model.setPassportID(rs.getString(i++));

                model.setSiblingName(rs.getString(i++));
                model.setSiblingAge(rs.getInt(i++));
                model.setSiblingJob(rs.getString(i++));
                model.setSiblingPlace(rs.getString(i++));
                model.setSiblingTel(rs.getString(i++));

                model.setHigth(rs.getInt(i++));
                model.setWeight(rs.getInt(i++));

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

}
