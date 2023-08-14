package DAO;

import DAOInterface.TeacherRankFn;
import Database.JoConnect;
import Database.JoSQL;
import Model.TeacherRankModel;
import Tools.JoAlert;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class TeacherRankDAO implements TeacherRankFn {

    private JoSQL sql = new JoSQL(new JoConnect().getConnectionDefault(), "tb_teacherrank");

    @Override
    public int CreaterTeacherRank(TeacherRankModel model) {
        try {
            PreparedStatement pre = sql.getCreate();
            return statement(pre, null, model.getTeacherID(), model.getYearID(), model.getRank()).executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateTeacherRank(TeacherRankModel model) {
        try {
            PreparedStatement pre = sql.getUpdate();
            return statement(pre, model.getTeacherID(), model.getYearID(), model.getRank(), model.getTeacherRankID()).executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int DeleteTeacherRank(TeacherRankModel model) {
        try {
            PreparedStatement pre = sql.getDelete();
            return statement(pre, model.getTeacherRankID()).executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public List<TeacherRankModel> getAllTeacherRank() {
        List<TeacherRankModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(rankModelMap(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public TeacherRankModel getTeacherRankById(int ID) {
        TeacherRankModel model = new TeacherRankModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                model = rankModelMap(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

    @Override
    public TeacherRankModel getTeacherRankByTeacherId(int ID, int YearID) {
        TeacherRankModel model = new TeacherRankModel();
        try {
            PreparedStatement pre = sql.getSelectCustom("TeacherID=? AND YearID=?");
            ResultSet rs = statement(pre, ID, YearID).executeQuery();
            if (rs.next()) {
                model = rankModelMap(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

    private TeacherRankModel rankModelMap(ResultSet rs) throws SQLException {
        return new TeacherRankModel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
    }

    private PreparedStatement statement(PreparedStatement query, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            query.setObject(i + 1, params[i]);
        }
        return query;
    }

}
