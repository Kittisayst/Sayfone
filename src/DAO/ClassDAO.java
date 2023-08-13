package DAO;

import Database.JoConnect;
import Database.JoSQL;
import Model.ClassModel;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassDAO implements DAOInterface.ClassFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private String tableName = "tb_class";
    private JoSQL sql = new JoSQL(c, tableName);

    @Override
    public int CreaterClass(ClassModel classModel) {
        try {
            PreparedStatement pre = sql.getCreate();
            pre.setInt(1, classModel.getClassID());
            pre.setString(2, classModel.getClassName());
            return pre.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public int UpdateClass(ClassModel classModel) {
        try {
            PreparedStatement pre = sql.getUpdate();
            pre.setString(1, classModel.getClassName());
            pre.setInt(2, classModel.getClassID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public int DeleteClass(ClassModel classModel) {
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, classModel.getClassID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public List<ClassModel> getAllClass() {
        List<ClassModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                ClassModel model = new ClassModel();
                model.setClassID(rs.getInt(1));
                model.setClassName(rs.getString(2));
                models.add(model);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } catch (Exception ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return models;
    }

    @Override
    public ClassModel getClassById(int ID) {
        ClassModel classModel = new ClassModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                classModel.setClassID(rs.getInt(1));
                classModel.setClassName(rs.getString(2));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return classModel;
    }

}
