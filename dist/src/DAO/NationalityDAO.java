package DAO;

import DAOInterface.NationalityFn;
import Database.JoConnect;
import Database.JoSQL;
import Model.NationalityModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NationalityDAO implements NationalityFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private JoSQL sql = new JoSQL(c, "tb_nationality");

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
        List<NationalityModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(new NationalityModel(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public NationalityModel getNationalityById(int NationalityID) {
        NationalityModel model = new NationalityModel();
        try {
            ResultSet rs = sql.getSelectById(NationalityID);
            if (rs.next()) {
                model = new NationalityModel(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

}
