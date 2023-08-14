package DAO;

import DAOInterface.TeacherVacinFn;
import Database.JoConnect;
import Database.JoSQL;
import Model.TeacherVaccinModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TeacherVaccinDAO implements TeacherVacinFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_teachervaccin";
    JoSQL sql = new JoSQL(c, TableName);

    @Override
    public int CreaterTeacherVaccin(TeacherVaccinModel model) {
        try {
            PreparedStatement pre = sql.getCreate();
            int i = 1;
            pre.setString(i++, null);
            pre.setInt(i++, model.getTeacherID());
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
    public int UpdateTeacherVaccin(TeacherVaccinModel model) {
        try {
            PreparedStatement pre = sql.getUpdate();
            int i = 1;
            pre.setInt(i++, model.getTeacherID());
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
    public int DeleteTeacherVaccin(TeacherVaccinModel model) {
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
    public List<TeacherVaccinModel> getTeacherVaccinAllByTeacherID(int TeacherID) {
        List<TeacherVaccinModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectByIndex(2, TeacherID);
            while (rs.next()) {
                TeacherVaccinModel model = new TeacherVaccinModel();
                int i = 1;
                model.setVaccinID(rs.getInt(i++));
                model.setTeacherID(rs.getInt(i++));
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
    public TeacherVaccinModel getTeacherVaccinById(int TeacherVaccinID) {
        TeacherVaccinModel model = new TeacherVaccinModel();
        try {
            ResultSet rs = sql.getSelectById(TeacherVaccinID);
            while (rs.next()) {
                int i = 1;
                model.setVaccinID(rs.getInt(i++));
                model.setTeacherID(rs.getInt(i++));
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
