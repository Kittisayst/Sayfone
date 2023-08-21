package DAO;

import DAOInterface.BrotherAndSisterFN;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.BrotherAndSisterModel;
import java.util.List;
import Tools.JoAlert;
import Utility.JoPrepared;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BrotherssistersDAO implements BrotherAndSisterFN {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_brotherssisters";
    private JoSQL sql = new JoSQL(c, TableName);

    @Override
    public int CreaterBrotherAndSister(BrotherAndSisterModel model) {
        try {
            PreparedStatement pre = new JoPrepared().setAutoPrepared(sql.getCreate(),
                    null,
                    model.getStudentID(),
                    model.getStudentBSID());
            System.out.println(pre);
            return pre.executeUpdate();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateBrotherAndSister(BrotherAndSisterModel model) {
        try {
            PreparedStatement pre = new JoPrepared().setAutoPrepared(sql.getUpdate(),
                    model.getStudentID(),
                    model.getStudentBSID(),
                    model.getBsID()
            );
            return pre.executeUpdate();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        }
    }

    @Override
    public int DeleteBrotherAndSister(BrotherAndSisterModel model) {
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getBsID());
            return pre.executeUpdate();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        }
    }

    @Override
    public List<BrotherAndSisterModel> getBrotherAndSisterAll() {
        List<BrotherAndSisterModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(getModel(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        }
        return models;
    }

    @Override
    public BrotherAndSisterModel getBrotherAndSisterById(int ID) {
        BrotherAndSisterModel model = new BrotherAndSisterModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                model = getModel(rs);
            }
            System.out.println(model);
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        }
        return model;
    }

    private BrotherAndSisterModel getModel(ResultSet rs) throws Exception {
        BrotherAndSisterModel BrotherAndSister = new BrotherAndSisterModel(rs.getInt(1), rs.getInt(2), rs.getInt("StudentBSID"));
        return BrotherAndSister;
    }

    @Override
    public List<BrotherAndSisterModel> getBrotherSisterAll(int StudentID) {
        List<BrotherAndSisterModel> models = new ArrayList<>();
        try {
            String sqlc = "SELECT bsID,tb_brotherssisters.StudentID,StudentBSID,StudentName,Gender,StudentNo FROM tb_brotherssisters\n"
                    + "INNER JOIN tb_student ON tb_brotherssisters.StudentBSID = tb_student.StudentID\n"
                    + "WHERE tb_brotherssisters.StudentID = ?";
            PreparedStatement pre = c.prepareStatement(sqlc);
            pre.setInt(1, StudentID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                BrotherAndSisterModel model = new BrotherAndSisterModel(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                model.setStudentName(rs.getString(4));
                model.setGender(rs.getInt(5));
                model.setStudentNo(rs.getString(6));
                models.add(model);
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        }
        return models;
    }

}
