package DAO;

import Database.JoConnect;
import Model.ClassModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO2 {

    private final Connection c = new JoConnect().getConnectionDefault();

    private PreparedStatement prepareStatement(String sql, Object... params) throws SQLException {
        PreparedStatement stmt = c.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
        return stmt;
    }

    private <T> List<T> executeQuery(String sql, ResultSetMapper<T> mapper, Object... params) {
        List<T> result = new ArrayList<>();
        try ( PreparedStatement stmt = prepareStatement(sql, params);  ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                T t = mapper.map(rs);
                result.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int createClass(ClassModel classModel) {
        String sql = "INSERT INTO tb_class VALUES (?, ?)";
        try ( PreparedStatement stmt = prepareStatement(sql, classModel.getClassID(), classModel.getClassName())) {
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateClass(ClassModel classModel) {
        String sql = "UPDATE tb_class SET className = ? WHERE classID = ?";
        try ( PreparedStatement stmt = prepareStatement(sql, classModel.getClassName(), classModel.getClassID())) {
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteClass(int classID) {
        String sql = "DELETE FROM tb_class WHERE classID = ?";
        try ( PreparedStatement stmt = prepareStatement(sql, classID)) {
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<ClassModel> getAllClasses() {
        String sql = "SELECT * FROM tb_class";
        return executeQuery(sql, this::mapClassModel);
    }


    public ClassModel getClassById(int classID) {
        String sql = "SELECT * FROM tb_class WHERE classID = ?";
        List<ClassModel> result = executeQuery(sql, this::mapClassModel, classID);
        return result.isEmpty() ? null : result.get(0);
    }

    private ClassModel mapClassModel(ResultSet rs) throws SQLException {
        int classID = rs.getInt("classID");
        String className = rs.getString("className");
        return new ClassModel(classID, className);
    }

    private interface ResultSetMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }
}
