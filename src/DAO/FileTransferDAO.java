package DAO;

import DAOInterface.FileTransferFn;
import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Model.FileTranferModel;
import java.util.List;
import Tools.JoAlert;
import Utility.JoPrepared;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FileTransferDAO implements FileTransferFn {

    private final String TableName = "tb_filetransfer";

    @Override
    public int Creater(FileTranferModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            FileInputStream fis = new FileInputStream(model.getFile());
            PreparedStatement pre = new JoPrepared().setAutoPrepared(sql.getCreate(),
                    null,
                    model.getFinancialID(),
                    model.getFileTranferDate(),
                    model.getTransferTime(),
                    fis);
            System.out.println(pre);
            return pre.executeUpdate();
        } catch (FileNotFoundException | SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public int Update(FileTranferModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            if (model.getFile() != null) {
                return updateImage(model);
            } else {
                PreparedStatement pre = new JoPrepared().setAutoPrepared(sql.getUpdateByColumns(new String[]{"transferDate", "transferTime"}),
                        model.getFileTranferDate(),
                        model.getTransferTime(),
                        model.getFileTranferID());
                System.out.println(pre);
                return pre.executeUpdate();
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }

    }

    private int updateImage(FileTranferModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            FileInputStream fis = new FileInputStream(model.getFile());
            PreparedStatement pre = new JoPrepared().setAutoPrepared(sql.getUpdateByColumns(new String[]{"image"}), fis, model.getFileTranferID());
            return pre.executeUpdate();
        } catch (FileNotFoundException | SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    @Override
    public int Delete(FileTranferModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getFileTranferID());
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
    public List<FileTranferModel> getFileTranferAll() {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        List<FileTranferModel> models = new ArrayList<>();
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
    public FileTranferModel getFileTranferById(int ID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        FileTranferModel model = new FileTranferModel();
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
    public FileTranferModel getFileTranferByFinancialID(int FinancialID) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        FileTranferModel model = new FileTranferModel();
        try {
            ResultSet rs = sql.getSelectByIndex(2, FinancialID);
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

    private FileTranferModel getResult(ResultSet rs) throws Exception {
        FileTranferModel model = new FileTranferModel(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), null);
        model.setImage(rs.getBlob(5));
        return model;
    }

}
