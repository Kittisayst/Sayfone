package DAO;

import DAOInterface.TeacherRankFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.TeacherRankModel;
import Tools.JoAlert;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class TeacherRankDAO implements TeacherRankFn {

    private String TableName = "tb_teacherrank";

    @Override
    public int CreaterTeacherRank(TeacherRankModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getCreate(), null, model.getTeacherID(), model.getYearID(), model.getRank(), model.getMonth());
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
    public int UpdateTeacherRank(TeacherRankModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getUpdate(), model.getTeacherID(), model.getYearID(), model.getRank(),  model.getMonth(), model.getTeacherRankID());
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
    public int DeleteTeacherRank(TeacherRankModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getRank());
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
    public List<TeacherRankModel> getAllTeacherRank() {
        List<TeacherRankModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(getResult(rs));
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
    public TeacherRankModel getTeacherRankById(int ID) {
        TeacherRankModel model = new TeacherRankModel();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                model = getResult(rs);
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
    public TeacherRankModel getTeacherRankByTeacherId(int ID, int YearID, int Month) {
        TeacherRankModel model = new TeacherRankModel();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getSelectCustom("TeacherID=? AND YearID=? AND month=?");
            pre.setInt(1, ID);
            pre.setInt(2, YearID);
            pre.setInt(3, Month);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                model = getResult(rs);
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

    private TeacherRankModel getResult(ResultSet rs) throws SQLException {
        return new TeacherRankModel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
    }

    @Override
    public int getMoney(int TeacherID) {
        JoConnect connect = new JoConnect();
        String sqlQuery = "SELECT SUM(Money) AS SumMoney FROM tb_teacherrank WHERE TeacherID = " + TeacherID;
        try {
            Connection c = connect.getConnectionDefault();
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            int money = 0;
            if (rs.next()) {
                money = rs.getInt(1);
                System.out.println(money);
            }
            return money;
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

}
