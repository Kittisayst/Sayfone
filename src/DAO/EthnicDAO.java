package DAO;

import DAOInterface.EthnicFn;
import Database.JoConnect;
import Database.JoSQL;
import Model.EthnicModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EthnicDAO implements EthnicFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private JoSQL sql = new JoSQL(c, "tb_ethnic");

    @Override
    public int CreaterEthnic(EthnicModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int UpdateEthnic(EthnicModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int DeleteEthnic(EthnicModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EthnicModel> getAllEthnic() {
        List<EthnicModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(new EthnicModel(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public EthnicModel getEthnicById(int ID) {
        EthnicModel model = new EthnicModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                model = new EthnicModel(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }
}
