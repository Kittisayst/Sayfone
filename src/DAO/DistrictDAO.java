package DAO;

import DAOInterface.DistrictFn;
import DAOSevervice.ProvinceService;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.DistrictModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DistrictDAO implements DistrictFn {

    private final String TableName = "tb_district";

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
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<DistrictModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                DistrictModel model = new DistrictModel();
                model.setDistrictID(rs.getInt(1));
                model.setDistrictName(rs.getString(3));
                models.add(model);
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public DistrictModel getDistrictById(int DistrictID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        DistrictModel model = new DistrictModel();
        try {
            ResultSet rs = sql.getSelectById(DistrictID);
            if (rs.next()) {
                model.setDistrictID(rs.getInt(1));
                model.setProvinceID(rs.getInt(2));
                model.setProvinceName(new ProvinceService().getProvinceById(rs.getInt(2)).getProvinceName());
                model.setDistrictName(rs.getString(3));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

    @Override
    public List<DistrictModel> getProvinceById(int ProvinceID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<DistrictModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = sql.getSelectCustom("pid=?");
            pre.setInt(1, ProvinceID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                DistrictModel model = new DistrictModel();
                model.setDistrictID(rs.getInt(1));
                model.setDistrictName(rs.getString(3));
                models.add(model);
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }
}
