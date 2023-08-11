package DAO;

import DAOInterface.DistrictFn;
import Database.JoConnect;
import Model.DistrictModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DistrictDAO implements DistrictFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String SQL_Create = "INSERT INTO tb_user VALUES(?,?,?,?,?,?)";
    private final String SQL_Update = "UPDATE tb_user SET tid=?,username=?,password=?,userlog=?,userdate=? WHERE uid=?";
    private final String SQL_Delete = "DELETE FROM tb_nationality WHERE nationalityID=?";
    private final String SQL_GET_All = "SELECT * FROM tb_district";
    private final String SQL_GET_ById = "SELECT did,tb_district.pid,pname,dname FROM tb_district\n"
            + "INNER JOIN tb_province ON tb_district.pid = tb_province.pid WHERE did=?";
    private final String SQL_GET_ByProvinceID = "SELECT * FROM tb_district WHERE pid=?";

    @Override
    public int CreaterDistrict(DistrictModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int UpdateDistrict(DistrictModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int DeleteDistrict(DistrictModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DistrictModel> getAllDistrict() {
        List<DistrictModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                DistrictModel model = new DistrictModel();
                model.setDistrictID(rs.getInt(1));
                model.setDistrictName(rs.getString(3));
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public DistrictModel getDistrictById(int DistrictID) {
        DistrictModel model = new DistrictModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ById);
            pre.setInt(1, DistrictID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                model.setDistrictID(rs.getInt(1));
                model.setProvinceID(rs.getInt(2));
                model.setProvinceName(rs.getString(3));
                model.setDistrictName(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public List<DistrictModel> getProvinceById(int ProvinceID) {
        List<DistrictModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ByProvinceID);
            pre.setInt(1, ProvinceID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                DistrictModel model = new DistrictModel();
                model.setDistrictID(rs.getInt(1));
                model.setDistrictName(rs.getString(3));
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }
}
