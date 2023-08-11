package DAO;

import DAOInterface.FileTransferFn;
import Database.JoConnect;
import Database.JoSQL;
import Model.FileTranferModel;
import java.util.List;
import Tools.JoAlert;
import Utility.JoPrepared;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FileTransferDAO implements FileTransferFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_filetransfer";
    private JoSQL sql = new JoSQL(c, TableName);

    @Override
    public int Creater(FileTranferModel model) {
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
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int Update(FileTranferModel model) {
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
            e.printStackTrace();
            return 0;
        }

    }

    private int updateImage(FileTranferModel model) throws Exception {
        FileInputStream fis = new FileInputStream(model.getFile());
        PreparedStatement pre = new JoPrepared().setAutoPrepared(sql.getUpdateByColumns(new String[]{"image"}), fis, model.getFileTranferID());
        System.out.println(pre);
        return pre.executeUpdate();
    }

    @Override
    public int Delete(FileTranferModel model) {
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getFileTranferID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<FileTranferModel> getFileTranferAll() {
        List<FileTranferModel> models = new ArrayList<>();
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                models.add(getResult(rs));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return models;
    }

    @Override
    public FileTranferModel getFileTranferById(int ID) {
        FileTranferModel model = new FileTranferModel();
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

    @Override
    public FileTranferModel getFileTranferByFinancialID(int FinancialID) {
        FileTranferModel model = new FileTranferModel();
        try {
            ResultSet rs = sql.getSelectByIndex(2, FinancialID);
            if (rs.next()) {
                model = getResult(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

    private FileTranferModel getResult(ResultSet rs) throws Exception {
        FileTranferModel model = new FileTranferModel(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), null);
        model.setImage(rs.getBlob(5));
        return model;
    }

}
