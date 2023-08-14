package DAO;

import DAOInterface.StudentVaccinceFn;
import Database.JoConnect;
import Database.JoSQL;
import Model.StudentVacinceModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentVacinceDAO implements StudentVaccinceFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_studentvaccince";
    private final JoSQL sql = new JoSQL(c, TableName);

    @Override
    public int CreaterStudentVacince(StudentVacinceModel model) {
        try {
            PreparedStatement pre = sql.getCreate();
            int i = 1;
            pre.setString(i++, null);
            pre.setInt(i++, model.getStudentID());
            pre.setString(i++, model.getVaccinNo());
            pre.setString(i++, model.getVaccinName());
            pre.setString(i++, model.getVaccinCategory());
            pre.setString(i++, model.getLocation());
            pre.setDate(i++, model.getDate());
            pre.setString(i++, model.getDoctorName());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateStudentVacince(StudentVacinceModel model) {
        try {
            PreparedStatement pre = sql.getUpdate();
            int i = 1;
            pre.setInt(i++, model.getStudentID());
            pre.setString(i++, model.getVaccinNo());
            pre.setString(i++, model.getVaccinName());
            pre.setString(i++, model.getVaccinCategory());
            pre.setString(i++, model.getLocation());
            pre.setDate(i++, model.getDate());
            pre.setString(i++, model.getDoctorName());
            pre.setInt(i++, model.getVaccinID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int DeleteStudentVacince(StudentVacinceModel model) {
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getVaccinID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public List<StudentVacinceModel> getStudentVacinceAllByStudentID(int StudentID) {
        List<StudentVacinceModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectByIndex(2, StudentID);
            while (rs.next()) {
                StudentVacinceModel model = new StudentVacinceModel();
                int i = 1;
                model.setVaccinID(rs.getInt(i++));
                model.setStudentID(rs.getInt(i++));
                model.setVaccinNo(rs.getString(i++));
                model.setVaccinName(rs.getString(i++));
                model.setVaccinCategory(rs.getString(i++));
                model.setLocation(rs.getString(i++));
                model.setData(rs.getDate(i++));
                model.setDoctorName(rs.getString(i++));
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public StudentVacinceModel getStudentVacinceById(int StudentVacinceID) {
        StudentVacinceModel model = new StudentVacinceModel();
        try {
            ResultSet rs = sql.getSelectById(StudentVacinceID);
            while (rs.next()) {
                int i = 1;
                model.setVaccinID(rs.getInt(i++));
                model.setStudentID(rs.getInt(i++));
                model.setVaccinNo(rs.getString(i++));
                model.setVaccinName(rs.getString(i++));
                model.setVaccinCategory(rs.getString(i++));
                model.setLocation(rs.getString(i++));
                model.setData(rs.getDate(i++));
                model.setDoctorName(rs.getString(i++));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

}
