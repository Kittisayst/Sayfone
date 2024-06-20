package DAO;

import DAOInterface.YearFn;
import DAOSevervice.YearService;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.YearModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class YearDAO implements YearFn {

    private final String TableName = "tb_year";

    @Override
    public int Creater(YearModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getCreate();
            pre.setString(1, null);
            pre.setString(2, model.getYear());
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public int Update(YearModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getUpdate();
            pre.setString(1, model.getYear());
            pre.setInt(2, model.getYearID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public int Delete(YearModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getYearID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public List<YearModel> getYearAll() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<YearModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll(JoSQL.ORDER.DESC);
            while (rs.next()) {
                models.add(new YearModel(rs.getInt(1), rs.getString(2)));
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
    public YearModel getYearById(int ID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        YearModel model = new YearModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                model = new YearModel(rs.getInt(1), rs.getString(2));
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
    public YearModel getLastYear() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        YearModel model = new YearModel();
        try {
            ResultSet rs = sql.getMaxColumn();
            if (rs.next()) {
                model.setYearID(rs.getInt(1));
                YearService service = new YearService();
                model.setYear(service.getYearById(model.getYearID()).getYear());
            }

        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

}
