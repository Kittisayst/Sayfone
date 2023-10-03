package DAO;

import DAOInterface.WithdrawFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.WithdrawModel;
import java.util.List;
import Tools.JoAlert;
import Utility.JoPrepared;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WithdrawDAO implements WithdrawFn {

    private final String TableName = "tb_withdraw";

    @Override
    public int CreaterWithdraw(WithdrawModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = new JoPrepared().setAutoPrepared(sql.getCreate(),
                    model.getWithdrawID(),
                    model.getFinacialID(),
                    model.getMoney(),
                    model.getTransferMoney(),
                    model.getWithdrawDate(),
                    model.getUserID(),
                    model.getUserAuthen(),
                    model.getWithdrawComment()
            );
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
    public int UpdateWithdraw(WithdrawModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = new JoPrepared().setAutoPrepared(sql.getUpdate(),
                    model.getFinacialID(),
                    model.getMoney(),
                    model.getTransferMoney(),
                    model.getWithdrawDate(),
                    model.getUserID(),
                    model.getUserAuthen(),
                    model.getWithdrawComment(),
                    model.getWithdrawID()
            );
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
    public int DeleteWithdraw(WithdrawModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getWithdrawID());
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
    public List<WithdrawModel> getWithdrawAll() {
        List<WithdrawModel> models = new ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(getResult(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return models;
    }

    @Override
    public WithdrawModel getWithdrawById(int ID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        WithdrawModel model = new WithdrawModel();
        try {
            ResultSet rs = sql.getSelectById(ID);
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
    public WithdrawModel getWithdrawByFinancailID(int FinancailID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        WithdrawModel model = new WithdrawModel();
        try {
            PreparedStatement pre = sql.getSelectCustom("finacialID=?");
            pre.setInt(1, FinancailID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                model = getResult(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return model;
    }

    private WithdrawModel getResult(ResultSet rs) throws Exception {
        return new WithdrawModel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
    }

}
