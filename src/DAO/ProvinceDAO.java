package DAO;

import DAOInterface.ProvinceFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.ProvinceModel;
import Tools.JoAlert;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProvinceDAO implements ProvinceFn {

    private final String TableName = "tb_province";

    @Override
    public int CreaterProvince(ProvinceModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int UpdateProvince(ProvinceModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int DeleteProvince(ProvinceModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProvinceModel> getAllProvince() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<ProvinceModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                ProvinceModel model = new ProvinceModel(rs.getInt(1), rs.getString(2));
                models.add(model);
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public ProvinceModel getProvinceById(int ProvinceID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        ProvinceModel model = new ProvinceModel();
        try {
            ResultSet rs = sql.getSelectById(ProvinceID);
            if (rs.next()) {
                model = new ProvinceModel(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return model;
    }
}
