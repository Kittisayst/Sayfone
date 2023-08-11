package DAO;

import DAOInterface.RegisterFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.CreateRegisterModel;
import java.util.List;
import Tools.JoAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterDAO implements RegisterFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_register";
    private JoSQL sql = new JoSQL(c, TableName);

    @Override
    public int Creater(CreateRegisterModel model) {
        try {
            PreparedStatement pre = getPrepareStatement(sql.getCreate(),
                    model.getRegisterID(),
                    model.getClassRoomName(),
                    model.getYearID(),
                    model.getClassID(),
                    model.getRegisterDate()
            );
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int Update(CreateRegisterModel model) {
        try {
            PreparedStatement pre = getPrepareStatement(sql.getUpdate(),
                    model.getClassRoomName(),
                    model.getYearID(),
                    model.getClassID(),
                    model.getRegisterDate(),
                    model.getRegisterID()
            );
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int Delete(int ID) {
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
    public List<CreateRegisterModel> getRegisterAll() {
        List<CreateRegisterModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(getResult(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public CreateRegisterModel getRegisterById(int ID) {
        CreateRegisterModel model = new CreateRegisterModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
            if (rs.next()) {
                model = getResult(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

    private CreateRegisterModel getResult(ResultSet rs) throws SQLException {
        return new CreateRegisterModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
    }

    private PreparedStatement getPrepareStatement(PreparedStatement pre, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pre.setObject(i + 1, params[i]);
        }
        return pre;
    }

    @Override
    public int getCountRegister() {
        int count = 0;
        try {
            count = sql.getCount();
        } catch (Exception e) {
            JoLoger.saveLog(e, count);
            JoAlert.Error(e, count);
        }
        return count;
    }

}
