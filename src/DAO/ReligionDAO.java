package DAO;

import DAOInterface.ReligionFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.ReligionModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReligionDAO implements ReligionFn {

    private String TableName = "tb_religion";

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
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<ReligionModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(new ReligionModel(rs.getInt(1), rs.getString(2)));
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
    public ReligionModel getReligionModelById(int ReligionModelID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        ReligionModel model = new ReligionModel();
        try {
            ResultSet rs = sql.getSelectById(ReligionModelID);
            if (rs.next()) {
                model = new ReligionModel(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        }finally{
            connect.close();
        }
        return model;
    }
}
