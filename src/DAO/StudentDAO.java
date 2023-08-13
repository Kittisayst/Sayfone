package DAO;

import DAOInterface.StudentFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.StudentModel;
import java.util.List;
import Tools.JoAlert;
import Utility.JoBlobConvert;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO implements StudentFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_student";
    JoSQL sql = new JoSQL(c, TableName);
    private final String SQL_Update = "UPDATE " + TableName + " SET StudentNo=?,Gender=?,StudentName=?,StudentENG=?,NickName=?,"
            + "DateofBirth=?,DateStart=?,DateStop=?,Preschool=?,Health=?,Talent=?,VaccinState=?,Disabled=?,Sibling=?,"
            + "GoHome=?,Status=?,nationalityID=?,ethnicID=?,religionID=? WHERE StudentID=?";
    private final String SQL_Delete = "DELETE FROM " + TableName + " WHERE StudentID=?";
    private final String SQL_GET_All = "SELECT * FROM " + TableName;
    private final String SQL_GET_ById = "SELECT * FROM " + TableName + " WHERE StudentID =?";
    private final String SQL_GET_LASTID = "SELECT MAX(StudentID) AS ID FROM " + TableName;
    private final String SQL_UpdateImage = "UPDATE " + TableName + " SET Image=? WHERE StudentID=?";
    private final String SQL_Count = "SELECT COUNT(StudentID) AS StudnetCount FROM " + TableName;
    private String SQL_GetNewStudent = "SELECT * FROM tb_student WHERE tb_student.StudentID NOT IN (SELECT tb_registerdetail.StudentID FROM tb_registerdetail)";

    @Override
    public int CreaterStudent(StudentModel model) {
        try {
            PreparedStatement pre = sql.getCreate();
            int i = 1;
            pre.setString(i++, null);
            pre.setString(i++, model.getStudentNo());
            pre.setInt(i++, model.getGender());
            pre.setString(i++, model.getStudentName());
            pre.setString(i++, model.getStudentENG());
            pre.setString(i++, model.getNickName());
            pre.setDate(i++, model.getDateofBirth());
            pre.setDate(i++, model.getDateStart());
            pre.setDate(i++, model.getDateStop());
            pre.setString(i++, model.getPreschool());
            pre.setInt(i++, model.getHealth());
            pre.setString(i++, model.getTalent());
            pre.setInt(i++, model.getVaccinState());
            pre.setString(i++, model.getDisabled());
            pre.setInt(i++, model.getSibling());
            if (model.getLocationFile() == null) {
                pre.setString(i++, null);
            } else {
                InputStream in = new JoBlobConvert(model.getLocationFile()).getFileInput();
                pre.setBinaryStream(i++, in, in.available());
            }
            pre.setInt(i++, model.getGoHome());
            pre.setInt(i++, model.getStatus());
            pre.setInt(i++, model.getNationalityID());
            pre.setInt(i++, model.getEthnicID());
            pre.setInt(i++, model.getReligionID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateStudent(StudentModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Update);
            int i = 1;
            pre.setString(i++, model.getStudentNo());
            pre.setInt(i++, model.getGender());
            pre.setString(i++, model.getStudentName());
            pre.setString(i++, model.getStudentENG());
            pre.setString(i++, model.getNickName());
            pre.setDate(i++, model.getDateofBirth());
            pre.setDate(i++, model.getDateStart());
            pre.setDate(i++, model.getDateStop());
            pre.setString(i++, model.getPreschool());
            pre.setInt(i++, model.getHealth());
            pre.setString(i++, model.getTalent());
            pre.setInt(i++, model.getVaccinState());
            pre.setString(i++, model.getDisabled());
            pre.setInt(i++, model.getSibling());
            if (model.getLocationFile() != null) {
                UpdateImage(model);
            }
            pre.setInt(i++, model.getGoHome());
            pre.setInt(i++, model.getStatus());
            pre.setInt(i++, model.getNationalityID());
            pre.setInt(i++, model.getEthnicID());
            pre.setInt(i++, model.getReligionID());
            pre.setInt(i++, model.getStudentID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int DeleteStudent(StudentModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Delete);
            pre.setInt(1, model.getStudentID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public List<StudentModel> getAllStudent() {
        List<StudentModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int i = 1;
                StudentModel model = new StudentModel();
                model.setStudentID(rs.getInt(i++));
                model.setStudentNo(rs.getString(i++));
                model.setGender(rs.getInt(i++));
                model.setStudentName(rs.getString(i++));
                model.setStudentENG(rs.getString(i++));
                model.setNickName(rs.getString(i++));
                model.setDateofBirth(rs.getDate(i++));
                model.setDateStart(rs.getDate(i++));
                model.setDateStop(rs.getDate(i++));
                model.setPreschool(rs.getString(i++));
                model.setHealth(rs.getInt(i++));
                model.setTalent(rs.getString(i++));
                model.setVaccinState(rs.getInt(i++));
                model.setDisabled(rs.getString(i++));
                model.setSibling(rs.getInt(i++));
                model.setImage(rs.getBlob(i++));
                model.setGoHome(rs.getInt(i++));
                model.setStatus(rs.getInt(i++));
                model.setNationalityID(rs.getInt(i++));
                model.setEthnicID(rs.getInt(i++));
                model.setReligionID(rs.getInt(i++));
                models.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public StudentModel getStudentById(int StudentID) {
        StudentModel model = new StudentModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ById);
            pre.setInt(1, StudentID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int i = 1;
                model.setStudentID(rs.getInt(i++));
                model.setStudentNo(rs.getString(i++));
                model.setGender(rs.getInt(i++));
                model.setStudentName(rs.getString(i++));
                model.setStudentENG(rs.getString(i++));
                model.setNickName(rs.getString(i++));
                model.setDateofBirth(rs.getDate(i++));
                model.setDateStart(rs.getDate(i++));
                model.setDateStop(rs.getDate(i++));
                model.setPreschool(rs.getString(i++));
                model.setHealth(rs.getInt(i++));
                model.setTalent(rs.getString(i++));
                model.setVaccinState(rs.getInt(i++));
                model.setDisabled(rs.getString(i++));
                model.setSibling(rs.getInt(i++));
                model.setImage(rs.getBlob(i++));
                model.setGoHome(rs.getInt(i++));
                model.setStatus(rs.getInt(i++));
                model.setNationalityID(rs.getInt(i++));
                model.setEthnicID(rs.getInt(i++));
                model.setReligionID(rs.getInt(i++));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

    @Override
    public int getSudentLastID() {
        int LastID = 0;
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_LASTID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                LastID = rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return LastID;
    }

    private void UpdateImage(StudentModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_UpdateImage);
            InputStream in = new JoBlobConvert(model.getLocationFile()).getFileInput();
            pre.setBinaryStream(1, in, in.available());
            pre.setInt(2, model.getStudentID());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
    }

    @Override
    public int getStudentCount() {
        int Count = 0;
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Count);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, Count);
        }
        return Count;
    }

    @Override
    public int getCountClass(int ClassID) {
        return sql.getCount();
    }

    @Override
    public List<StudentModel> getNewStudent() {
        List<StudentModel> models = new ArrayList<>();
        try {
            ResultSet rs = c.createStatement().executeQuery(SQL_GetNewStudent);
            while (rs.next()) {
                int i = 1;
                StudentModel model = new StudentModel();
                model.setStudentID(rs.getInt(i++));
                model.setStudentNo(rs.getString(i++));
                model.setGender(rs.getInt(i++));
                model.setStudentName(rs.getString(i++));
                model.setStudentENG(rs.getString(i++));
                model.setNickName(rs.getString(i++));
                model.setDateofBirth(rs.getDate(i++));
                model.setDateStart(rs.getDate(i++));
                model.setDateStop(rs.getDate(i++));
                model.setPreschool(rs.getString(i++));
                model.setHealth(rs.getInt(i++));
                model.setTalent(rs.getString(i++));
                model.setVaccinState(rs.getInt(i++));
                model.setDisabled(rs.getString(i++));
                model.setSibling(rs.getInt(i++));
                model.setImage(rs.getBlob(i++));
                model.setGoHome(rs.getInt(i++));
                model.setStatus(rs.getInt(i++));
                model.setNationalityID(rs.getInt(i++));
                model.setEthnicID(rs.getInt(i++));
                model.setReligionID(rs.getInt(i++));
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public List<StudentModel> getSutdentNotRegister() {
        List<StudentModel> models = new ArrayList<>();
        try {
            String sql = "SELECT s.*\n"
                    + "FROM tb_student s\n"
                    + "LEFT JOIN tb_financial f ON s.StudentID = f.StudentID\n"
                    + "WHERE f.StudentID IS NULL;";
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                int i = 1;
                StudentModel model = new StudentModel();
                model.setStudentID(rs.getInt(i++));
                model.setStudentNo(rs.getString(i++));
                model.setGender(rs.getInt(i++));
                model.setStudentName(rs.getString(i++));
                model.setStudentENG(rs.getString(i++));
                model.setNickName(rs.getString(i++));
                model.setDateofBirth(rs.getDate(i++));
                model.setDateStart(rs.getDate(i++));
                model.setDateStop(rs.getDate(i++));
                model.setPreschool(rs.getString(i++));
                model.setHealth(rs.getInt(i++));
                model.setTalent(rs.getString(i++));
                model.setVaccinState(rs.getInt(i++));
                model.setDisabled(rs.getString(i++));
                model.setSibling(rs.getInt(i++));
                model.setImage(rs.getBlob(i++));
                model.setGoHome(rs.getInt(i++));
                model.setStatus(rs.getInt(i++));
                model.setNationalityID(rs.getInt(i++));
                model.setEthnicID(rs.getInt(i++));
                model.setReligionID(rs.getInt(i++));
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public String getAutoStudentID() {
        try {
            StudentModel model = getStudentById(getSudentLastID());
            int num = Integer.parseInt(model.getStudentNo());
            num += 1;
            String formatted = String.format("%05d", num);
            return formatted;
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
            return "0000";
        }
    }

    @Override
    public boolean getChekStudentNo(String studentNo) {
        try {
            ResultSet rs = sql.getSelectByIndex(2, studentNo);
            String checkNo = "";
            if (rs.next()) {
                System.out.println(rs.getString(2));
                checkNo = rs.getString(2);
            }
            return checkNo.equals(studentNo);
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
            return false;
        }
    }

    @Override
    public List<StudentModel> getStudentBrotherSister(int StudentID) {
        List<StudentModel> models = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_student\n"
                    + "WHERE StudentID NOT IN (SELECT tb_brotherssisters.StudentBSID FROM tb_brotherssisters WHERE tb_brotherssisters.StudentID=?)\n"
                    + "AND StudentID NOT IN (?)";
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setInt(1, StudentID);
            pre.setInt(2, StudentID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                models.add(getResult(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    private StudentModel getResult(ResultSet rs) throws SQLException {
        int i = 1;
        StudentModel model = new StudentModel();
        model.setStudentID(rs.getInt(i++));
        model.setStudentNo(rs.getString(i++));
        model.setGender(rs.getInt(i++));
        model.setStudentName(rs.getString(i++));
        model.setStudentENG(rs.getString(i++));
        model.setNickName(rs.getString(i++));
        model.setDateofBirth(rs.getDate(i++));
        model.setDateStart(rs.getDate(i++));
        model.setDateStop(rs.getDate(i++));
        model.setPreschool(rs.getString(i++));
        model.setHealth(rs.getInt(i++));
        model.setTalent(rs.getString(i++));
        model.setVaccinState(rs.getInt(i++));
        model.setDisabled(rs.getString(i++));
        model.setSibling(rs.getInt(i++));
        model.setImage(rs.getBlob(i++));
        model.setGoHome(rs.getInt(i++));
        model.setStatus(rs.getInt(i++));
        model.setNationalityID(rs.getInt(i++));
        model.setEthnicID(rs.getInt(i++));
        model.setReligionID(rs.getInt(i++));
        return model;
    }

}
