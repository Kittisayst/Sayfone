package DAO;

import DAOInterface.DAO;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.TimingModel;
import Tools.JoAlert;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimingDAO implements DAO<TimingModel> {

    private final String TableName = "tb_timing";

    @Override
    public int create(TimingModel data) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getCreate(), data.getTimingID(), data.getHour(), data.getMinute(), data.getSecond());
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
    public TimingModel read(int id) {
        TimingModel model = new TimingModel();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectById(id);
            if (rs.next()) {
                model = getResult(rs);
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

    public TimingModel getTimingStart() {
        TimingModel model = new TimingModel();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectById(1);
            if (rs.next()) {
                String data[] = rs.getString(2).split(":");
                model = new TimingModel(rs.getInt(1), data[0], data[1], data[2]);
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

    public TimingModel getTimingStop() {
        TimingModel model = new TimingModel();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectById(1);
            if (rs.next()) {
                String data[] = rs.getString(3).split(":");
                model = new TimingModel(rs.getInt(1), data[0], data[1], data[2]);
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
    public int update(TimingModel data) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getUpdate(), data.getHour(), data.getMinute(), data.getSecond(), data.getTimingID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    public int UpdateTime(int ID, String Timestart, String Timestop) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getUpdate(), Timestart, Timestop, ID);
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
    public int delete(int id) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, id);
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
    public List<TimingModel> getAll() {
        List<TimingModel> list = new ArrayList<>();
        return list;
    }

    @Override
    public TimingModel getResult(ResultSet rs) throws Exception {
        return new TimingModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
    }

}
