package DAO;

import DAOInterface.SubjectFn;
import Database.JoConnect;
import Database.JoSQL;
import Model.SubjectModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SubjectDAO implements SubjectFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_subject";
    JoSQL sql = new JoSQL(c, TableName);

    @Override
    public int CreaterSubject(SubjectModel model) {
        try {
            PreparedStatement pre = sql.getCreate();
            pre.setString(1, null);
            pre.setString(2, model.getSubjectName());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateSubject(SubjectModel model) {
        try {
            PreparedStatement pre = sql.getUpdate();
            pre.setString(1, model.getSubjectName());
            pre.setInt(2, model.getSubjectID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int DeleteSubject(int ID) {
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, ID);
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public List<SubjectModel> getAll() {
        List<SubjectModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(new SubjectModel(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public SubjectModel getSubjectById(int ID) {
        SubjectModel model = new SubjectModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                model = new SubjectModel(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

}
