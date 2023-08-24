package DAO;

import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.ClassModel;
import Tools.JoAlert;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassDAO implements DAOInterface.ClassFn {

    private String TableName = "tb_class";

    @Override
    public int CreaterClass(ClassModel classModel) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getCreate();
            pre.setInt(1, classModel.getClassID());
            pre.setString(2, classModel.getClassName());
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
    public int UpdateClass(ClassModel classModel) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getUpdate();
            pre.setString(1, classModel.getClassName());
            pre.setInt(2, classModel.getClassID());
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
    public int DeleteClass(ClassModel classModel) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, classModel.getClassID());
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
    public List<ClassModel> getAllClass() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<ClassModel> models = new ArrayList<>();
        models.clear();
        ResultSet rs;
        try {
            rs = sql.getSelectAll();
            while (rs.next()) {
                ClassModel model = new ClassModel();
                model.setClassID(rs.getInt(1));
                model.setClassName(rs.getString(2));
                models.add(model);
            }
            rs.close();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } catch (Exception ex) {
            JoAlert.Error(ex, this);
            JoLoger.saveLog(ex, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public ClassModel getClassById(int ID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        ClassModel classModel = new ClassModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                classModel.setClassID(rs.getInt(1));
                classModel.setClassName(rs.getString(2));
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return classModel;
    }

}
