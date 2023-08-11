package DAO;

import Database.JoConnect;
import Model.ClassModel;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassDAO implements DAOInterface.ClassFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String SQL_Create_Class = "INSERT INTO tb_class VALUES(?,?)";
    private final String SQL_Update_Class = "UPDATE tb_class SET className=? WHERE classID=?";
    private final String SQL_Delete_Class = "DELETE FROM tb_class WHERE classID=?";
    private final String SQL_GET_All_Class = "SELECT * FROM tb_class";
    private final String SQL_GET_ById_Class = "SELECT * FROM tb_class WHERE classID=?";

    @Override
    public int CreaterClass(ClassModel classModel) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Create_Class);
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
            PreparedStatement pre = c.prepareStatement(SQL_Update_Class);
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
            PreparedStatement pre = c.prepareStatement(SQL_Delete_Class);
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
            PreparedStatement pre = c.prepareStatement(SQL_GET_All_Class);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ClassModel model = new ClassModel();
                model.setClassID(rs.getInt(1));
                model.setClassName(rs.getString(2));
                models.add(model);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return models;
    }

    @Override
    public ClassModel getClassById(int ID) {
        ClassModel classModel = new ClassModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ById_Class);
            pre.setInt(1, ID);
            ResultSet rs = pre.executeQuery();
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
