package DAO;

import DAOInterface.StudentAddressFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.ChartStudentAddree;
import Model.CountVillageModel;
import Model.StudentAddressModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAddressDAO implements StudentAddressFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_studentlocation";
    private final String SQL_Create = "INSERT INTO " + TableName + " VALUES(?,?,?,?,?,?)";
    private final String SQL_Update = "UPDATE " + TableName + " SET did=?,didNow=?,Village=?,VillageNow=? WHERE LocationID=?";
    private final String SQL_Delete = "DELETE FROM " + TableName + " WHERE LocationID=?";
    private final String SQL_GET_All = "SELECT * FROM " + TableName;
    private final String SQL_GET_ById = "SELECT * FROM " + TableName + " WHERE StudentID=?";

    @Override
    public int CreaterStudentLocation(StudentAddressModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Create);
            pre.setString(1, null);
            pre.setInt(2, model.getStudentID());
            pre.setInt(3, model.getDistrictID());
            pre.setInt(4, model.getDistrictNowID());
            pre.setString(5, model.getVillage());
            pre.setString(6, model.getVillageNow());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateStudentLocation(StudentAddressModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Update);
            pre.setInt(1, model.getDistrictID());
            pre.setInt(2, model.getDistrictNowID());
            pre.setString(3, model.getVillage());
            pre.setString(4, model.getVillageNow());
            pre.setInt(5, model.getAddressID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int DeleteStudentLocation(StudentAddressModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Delete);
            pre.setInt(1, model.getAddressID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public List<StudentAddressModel> getAllStudentLocation() {
        List<StudentAddressModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                StudentAddressModel model = new StudentAddressModel();
                model.setAddressID(rs.getInt(1));
                model.setStudentID(rs.getInt(2));
                model.setDistrictID(rs.getInt(3));
                model.setDistrictNowID(rs.getInt(4));
                model.setVillage(rs.getString(5));
                model.setVillageNow(rs.getString(6));
                models.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public StudentAddressModel getStudentLocationByStudentID(int StudentID) {
        StudentAddressModel model = new StudentAddressModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ById);
            pre.setInt(1, StudentID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                model.setAddressID(rs.getInt(1));
                model.setStudentID(rs.getInt(2));
                model.setDistrictID(rs.getInt(3));
                model.setDistrictNowID(rs.getInt(4));
                model.setVillage(rs.getString(5));
                model.setVillageNow(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

    public List<ChartStudentAddree> getChartStudentAddressDistrict(boolean isDistrictNow) {
        String disID = isDistrictNow ? "lc.didNow" : "lc.did";
        List<ChartStudentAddree> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT ds.dname,COUNT(*)AS discount FROM tb_studentlocation AS lc\n"
                    + "INNER JOIN tb_district AS ds ON " + disID + " = ds.did\n"
                    + "GROUP BY " + disID;
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            while (rs.next()) {
                models.add(new ChartStudentAddree(rs.getString(1), rs.getInt(2)));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    public List<ChartStudentAddree> getChartStudentProvince(boolean isDistrictNow) {
        String disID = isDistrictNow ? "lc.didNow" : "lc.did";
        List<ChartStudentAddree> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        try {
            String sql = "SELECT pv.pname,COUNT(StudentID)AS pvcount FROM tb_studentlocation AS lc\n"
                    + "INNER JOIN tb_district AS ds ON " + disID + " = ds.did\n"
                    + "INNER JOIN tb_province AS pv ON ds.pid = pv.pid\n"
                    + "GROUP BY pv.pname";
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            while (rs.next()) {
                models.add(new ChartStudentAddree(rs.getString(1), rs.getInt(2)));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    public List<CountVillageModel> getCountVillageCurrent() {
        JoConnect connect = new JoConnect();
        List<CountVillageModel> models = new ArrayList<>();
        try {
            String sql = "SELECT p.pname AS ProvinceName,d.dname AS DistrictName,sl.Village,COUNT(*) AS VillageCount\n"
                    + "FROM tb_studentlocation AS sl\n"
                    + "JOIN tb_district AS d ON sl.did = d.did\n"
                    + "JOIN tb_province AS p ON d.pid = p.pid\n"
                    + "GROUP BY Village ORDER BY VillageCount DESC";
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            while (rs.next()) {
                models.add(new CountVillageModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    public List<CountVillageModel> getCountVillageNow() {
        JoConnect connect = new JoConnect();
        List<CountVillageModel> models = new ArrayList<>();
        try {
            String sql = "SELECT p.pname AS ProvinceName,d.dname AS DistrictName,sl.VillageNow,COUNT(*) AS VillageCount\n"
                    + "FROM tb_studentlocation AS sl\n"
                    + "JOIN tb_district AS d ON sl.didNow = d.did\n"
                    + "JOIN tb_province AS p ON d.pid = p.pid\n"
                    + "GROUP BY sl.VillageNow ORDER BY VillageCount DESC";
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            while (rs.next()) {
                models.add(new CountVillageModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

}
