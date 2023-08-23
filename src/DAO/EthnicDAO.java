package DAO;

import DAOInterface.EthnicFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.EthnicModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EthnicDAO implements EthnicFn {

    private String TableName = "tb_ethnic";

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
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<EthnicModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(new EthnicModel(rs.getInt(1), rs.getString(2)));
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
    public EthnicModel getEthnicById(int ID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        EthnicModel model = new EthnicModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                model = new EthnicModel(rs.getInt(1), rs.getString(2));
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
