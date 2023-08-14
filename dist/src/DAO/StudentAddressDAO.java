package DAO;

import DAOInterface.StudentAddressFn;
import Database.JoConnect;
import Model.StudentAddressModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentAddressDAO implements StudentAddressFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_studentlocation";
    private final String SQL_Create = "INSERT INTO " + TableName + " VALUES(?,?,?,?,?,?)";
    private final String SQL_Update = "UPDATE " + TableName + " SET did=?,didNow=?,Village=?,VillageNow=? WHERE LocationID=?";
    private final String SQL_Delete = "DELETE FROM " + TableName + " WHERE LocationID=?";
    private final String SQL_GET_All = "SELECT * FROM " + TableName;
    private final String SQL_GET_ById = "SELECT * FROM " + TableName + " WHERE StudentID=?";

    @Override
    public int CreaterStudentLocation(StudentAddressModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Create);
            pre.setString(1, null);
            pre.setInt(2, model.getStudentID());
            pre.setInt(3, model.getDistrictID());
            pre.setInt(4, model.getDistrictNowID());
            pre.setString(5, model.getVillage());
            pre.setString(6, model.getVillageNow());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateStudentLocation(StudentAddressModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Update);
            pre.setInt(1, model.getDistrictID());
            pre.setInt(2, model.getDistrictNowID());
            pre.setString(3, model.getVillage());
            pre.setString(4, model.getVillageNow());
            pre.setInt(5, model.getAddressID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int DeleteStudentLocation(StudentAddressModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Delete);
            pre.setInt(1, model.getAddressID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public List<StudentAddressModel> getAllStudentLocation() {
        List<StudentAddressModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                StudentAddressModel model = new StudentAddressModel();
                model.setAddressID(rs.getInt(1));
                model.setStudentID(rs.getInt(2));
                model.setDistrictID(rs.getInt(3));
                model.setDistrictNowID(rs.getInt(4));
                model.setVillage(rs.getString(5));
                model.setVillageNow(rs.getString(6));
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public StudentAddressModel getStudentLocationByStudentID(int StudentID) {
        StudentAddressModel model = new StudentAddressModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ById);
            pre.setInt(1, StudentID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                model.setAddressID(rs.getInt(1));
                model.setStudentID(rs.getInt(2));
                model.setDistrictID(rs.getInt(3));
                model.setDistrictNowID(rs.getInt(4));
                model.setVillage(rs.getString(5));
                model.setVillageNow(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }
}
