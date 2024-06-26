package DAO;

import DAOInterface.DAO;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.StudentKnowModel;
import Tools.JoAlert;
import java.sql.ResultSet;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentKnowDAO implements DAO<StudentKnowModel> {

    private final String TableName = "tb_studentknow";

    @Override
    public int create(StudentKnowModel data) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getCreate(), data.getKnowID(), data.getStudentID(), data.getKnowIndex());
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            System.out.println(e.getMessage());
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public StudentKnowModel read(int id) {
        JoConnect connect = new JoConnect();
        StudentKnowModel model = new StudentKnowModel();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectByIndex(2, id);
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

    @Override
    public int update(StudentKnowModel data) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.setPrepared(sql.getUpdate(), data.getStudentID(), data.getKnowIndex(), data.getKnowID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            System.out.println(e.getMessage());
            return 0;
        } finally {
            connect.close();
        }
    }

    public List<String> getKnowList() {
        JoConnect connect = new JoConnect();
        List<String> knowLists = new ArrayList<>();
        String strList = "";
        try {
            String sql = "SELECT * FROM tb_sayfone WHERE id =2";
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
            if (rs.next()) {
                strList = rs.getString(3);
            }
            if (!strList.isEmpty()) {
                strList = strList.substring(1, strList.length() - 1);
                // Split the string by ", "
                String[] stringArray = strList.split(", ");
                for (String element : stringArray) {
                    knowLists.add(element.substring(1, element.length() - 1));
                }
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return knowLists;
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<StudentKnowModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public StudentKnowModel getResult(ResultSet rs) throws Exception {
        return new StudentKnowModel(rs.getInt(1), rs.getInt(2), rs.getInt(3));
    }

}
