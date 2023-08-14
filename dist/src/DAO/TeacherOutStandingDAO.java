package DAO;

import DAOInterface.TeacherOutStandingFn;
import Database.JoConnect;
import Model.TeacherOutstandingModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherOutStandingDAO implements TeacherOutStandingFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_teacheroutstanding";
    private final String SQL_Create = "INSERT INTO " + TableName + " VALUES(?,?,?,?,?)";
    private final String SQL_Update = "UPDATE " + TableName + " SET OutstandingCatID=?,OutstandingDate=?,OutstandingDetail=? WHERE TeacherOutstandingID=?";
    private final String SQL_Delete = "DELETE FROM " + TableName + " WHERE TeacherOutstandingID=?";
    private final String SQL_GET_All_ByTeacherID = "SELECT TeacherOutstandingID,tb_teacheroutstanding.OutstandingCatID,OutstandingName,TeacherID,OutstandingDate,OutstandingDetail \n"
            + "FROM tb_teacheroutstanding\n"
            + "INNER JOIN tb_outstandingcat ON tb_teacheroutstanding.OutstandingCatID=tb_outstandingcat.OutstandingID\n"
            + "WHERE TeacherID=?";
    private final String SQL_GET_ByID = "SELECT * FROM "+TableName+" WHERE TeacherOutstandingID=?";

    @Override
    public int CreaterTeacherOutstanding(TeacherOutstandingModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Create);
            pre.setString(1, null);
            pre.setInt(2, model.getOutstandingCatID());
            pre.setInt(3, model.getTeacherID());
            pre.setDate(4, model.getOutstandingDate());
            pre.setString(5, model.getOutstandingDetail());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateTeacherOutstanding(TeacherOutstandingModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Update);
            pre.setInt(1, model.getOutstandingCatID());
            pre.setDate(2, model.getOutstandingDate());
            pre.setString(3, model.getOutstandingDetail());
            pre.setInt(4, model.getTeacherOutstandingID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int DeleteTeacherOutstanding(TeacherOutstandingModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Delete);
            pre.setInt(1, model.getTeacherOutstandingID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public List<TeacherOutstandingModel> getAllByTeacherID(int TeacherID) {
        List<TeacherOutstandingModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All_ByTeacherID);
            pre.setInt(1, TeacherID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                TeacherOutstandingModel model = new TeacherOutstandingModel();
                int i = 1;
                model.setTeacherOutstandingID(rs.getInt(i++));
                model.setOutstandingCatID(rs.getInt(i++));
                model.setOutstandingName(rs.getString(i++));
                model.setTeacherID(rs.getInt(i++));
                model.setOutstandingDate(rs.getDate(i++));
                model.setOutstandingDetail(rs.getString(i++));
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public TeacherOutstandingModel getByTeacherOutstandingID(int TeacherOutstandingID) {
        TeacherOutstandingModel model = new TeacherOutstandingModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ByID);
            pre.setInt(1, TeacherOutstandingID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int i = 1;
                model.setTeacherOutstandingID(rs.getInt(i++));
                model.setOutstandingCatID(rs.getInt(i++));
                model.setTeacherID(rs.getInt(i++));
                model.setOutstandingDate(rs.getDate(i++));
                model.setOutstandingDetail(rs.getString(i++));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }
}
