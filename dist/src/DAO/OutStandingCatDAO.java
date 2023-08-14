package DAO;

import DAOInterface.OutStandingCatFn;
import Database.JoConnect;
import Model.OutstandingCatModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OutStandingCatDAO implements OutStandingCatFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_outstandingcat";
    private final String SQL_Create = "INSERT INTO " + TableName + " VALUES(?,?)";
    private final String SQL_Update = "UPDATE " + TableName + " SET OutstandingName=? WHERE OutstandingID=?";
    private final String SQL_Delete = "DELETE FROM " + TableName + " WHERE OutstandingID=?";
    private final String SQL_GET_All = "SELECT * FROM " + TableName;
    private final String SQL_GET_ById = "SELECT * FROM " + TableName + " WHERE OutstandingID=?";

    @Override
    public int Creater(OutstandingCatModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Create);
            pre.setInt(1, model.getOutstandingCatID());
            pre.setString(2, model.getOutstandingName());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int Update(OutstandingCatModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Update);
            pre.setString(1, model.getOutstandingName());
            pre.setInt(2, model.getOutstandingCatID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int Delete(OutstandingCatModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Delete);
            pre.setString(1, model.getOutstandingName());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<OutstandingCatModel> getAllOutstanding() {
        List<OutstandingCatModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                OutstandingCatModel catModel = new OutstandingCatModel();
                catModel.setOutstandingCatID(rs.getInt(1));
                catModel.setOutstandingName(rs.getString(2));
                models.add(catModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public OutstandingCatModel getOutstandingById(int OutstandingID) {
        OutstandingCatModel catModel = new OutstandingCatModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ById);
            pre.setInt(1, OutstandingID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                catModel.setOutstandingCatID(rs.getInt(1));
                catModel.setOutstandingName(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return catModel;
    }
}
