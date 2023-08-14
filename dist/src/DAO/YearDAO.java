package DAO;

import DAOInterface.YearFn;
import DAOSevervice.YearService;
import Database.JoConnect;
import Database.JoSQL;
import Model.YearModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class YearDAO implements YearFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_year";
    private JoSQL sql = new JoSQL(c, TableName);

    @Override
    public int Creater(YearModel model) {
        try {
            PreparedStatement pre = sql.getCreate();
            pre.setString(1, null);
            pre.setString(2, model.getYear());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int Update(YearModel model) {
        try {
            PreparedStatement pre = sql.getUpdate();
            pre.setString(1, model.getYear());
            pre.setInt(2, model.getYearID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int Delete(YearModel model) {
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getYearID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public List<YearModel> getYearAll() {
        List<YearModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(new YearModel(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public YearModel getYearById(int ID) {
        YearModel model = new YearModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                model = new YearModel(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

    @Override
    public YearModel getLastYear() {
        YearModel model = new YearModel();
        try {
            ResultSet rs = sql.getMaxColumn();
            if (rs.next()) {
                model.setYearID(rs.getInt(1));
                YearService service = new YearService();
                model.setYear(service.getYearById(model.getYearID()).getYear());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

}
