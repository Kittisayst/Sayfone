package DAO;

import DAOInterface.NationalityFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.NationalityModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NationalityDAO implements NationalityFn {

    private String TableName = "tb_nationality";

    @Override
    public int CreaterNationality(NationalityModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int UpdateNationality(NationalityModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int DeleteNationality(NationalityModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NationalityModel> getAllNationality() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<NationalityModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(new NationalityModel(rs.getInt(1), rs.getString(2)));
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
    public NationalityModel getNationalityById(int NationalityID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        NationalityModel model = new NationalityModel();
        try {
            ResultSet rs = sql.getSelectById(NationalityID);
            if (rs.next()) {
                model = new NationalityModel(rs.getInt(1), rs.getString(2));
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
