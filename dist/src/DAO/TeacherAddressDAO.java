package DAO;

import DAOInterface.TeacherAddressFn;
import Database.JoConnect;
import Model.DistrictModel;
import Model.TeacherAddressModel;
import Tools.JoAlert;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherAddressDAO implements TeacherAddressFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String SQL_Create = "INSERT INTO tb_teacheraddress VALUES(?,?,?,?,?,?)";
    private final String SQL_Update = "UPDATE tb_teacheraddress SET DistrictID=?,DistrictNowID=?,Village=?,VillageNow=? WHERE TeacherID=?";
    private final String SQL_Delete = "DELETE FROM tb_teacheraddress WHERE TeacherID=?";
    private final String SQL_GET_All = "SELECT * FROM tb_teacheraddress";
    private final String SQL_GET_ByTeacherID = "SELECT * FROM tb_teacheraddress WHERE TeacherID=?";

    @Override
    public int CreaterTeacherAddress(TeacherAddressModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Create);
            int i = 1;
            pre.setString(i++, null);
            pre.setInt(i++, model.getDistrictID());
            pre.setInt(i++, model.getDistrictNowID());
            pre.setInt(i++, model.getTeacherID());
            pre.setString(i++, model.getVillage());
            pre.setString(i++, model.getVillageNow());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int UpdateTeacherAddress(TeacherAddressModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Update);
            int i = 1;
            pre.setInt(i++, model.getDistrictID());
            pre.setInt(i++, model.getDistrictNowID());
            pre.setString(i++, model.getVillage());
            pre.setString(i++, model.getVillageNow());
            pre.setInt(i++, model.getTeacherID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int DeleteTeacherAddress(TeacherAddressModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Delete);
            pre.setInt(1, model.getAddressID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert alert = new JoAlert();
            return 0;
        }
    }

    @Override
    public List<TeacherAddressModel> getAllTeacherAddress() {
        List<TeacherAddressModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                TeacherAddressModel model = new TeacherAddressModel();
                model.setAddressID(rs.getInt(1));
                model.setDistrictID(rs.getInt(2));
                model.setDistrictNowID(rs.getInt(3));
                model.setTeacherID(rs.getInt(4));
                model.setVillage(rs.getString(5));
                model.setVillageNow(rs.getString(6));
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public TeacherAddressModel getTeacherAddressById(int TeacherAddressID) {
        TeacherAddressModel model = new TeacherAddressModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ByTeacherID);
            pre.setInt(1, TeacherAddressID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                model.setAddressID(rs.getInt(1));
                model.setDistrictID(rs.getInt(2));
                model.setDistrictNowID(rs.getInt(3));
                model.setTeacherID(rs.getInt(4));
                model.setVillage(rs.getString(5));
                model.setVillageNow(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

}
