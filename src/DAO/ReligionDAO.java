package DAO;

import DAOInterface.ReligionFn;
import Database.JoConnect;
import Database.JoSQL;
import Model.ReligionModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReligionDAO implements ReligionFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private JoSQL sql = new JoSQL(c, "tb_religion");

    @Override
    public int CreaterReligionModel(ReligionModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int UpdateReligionModel(ReligionModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int DeleteReligionModel(ReligionModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReligionModel> getAllReligionModel() {
        List<ReligionModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(new ReligionModel(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public ReligionModel getReligionModelById(int ReligionModelID) {
        ReligionModel model = new ReligionModel();
        try {
            ResultSet rs = sql.getSelectById(ReligionModelID);
            if (rs.next()) {
                model = new ReligionModel(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }
}
