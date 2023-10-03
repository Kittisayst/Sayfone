package DAO;

import DAOInterface.FileTransferFn;
import Database.JoConnect;
import Database.JoProperties;
import Database.JoSQL;
import Log.JoLoger;
import Main.JoHttp;
import Main.JoUploadFile;
import Model.FileTranferModel;
import java.util.List;
import Tools.JoAlert;
import Utility.JoPrepared;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileTransferDAO implements FileTransferFn {

    private final String TableName = "tb_filetransfer";
    private JoProperties property = new JoProperties("/JoConfig/config.properties");
    private String server = property.getValueAt("db.Server");

    @Override
    public int Creater(FileTranferModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
        String FileName = model.getFinancialID() + "-" + dateFormat.format(new Date());
        JoUploadFile uploadFile = new JoUploadFile("http://" + server + "/sayfone/upload.php", "fileToUpload", model.getFile(), FileName);
        try {
            if (uploadFile.upload()) {
                PreparedStatement pre = new JoPrepared().setAutoPrepared(sql.getCreate(),
                        null,
                        model.getFinancialID(),
                        model.getFileTranferDate(),
                        model.getTransferTime(),
                        FileName + "." + uploadFile.getExtension());
                return pre.executeUpdate();
            } else {
                return 0;
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
            uploadFile.close();
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
                return pre.executeUpdate();
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }

    }

    private int updateImage(FileTranferModel model) {
        JoConnect connect = new JoConnect();
        String sql = "UPDATE tb_filetransfer SET fileName=? WHERE transferID=?";
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
        String FileName = model.getFinancialID() + "-" + dateFormat.format(new Date());
        JoUploadFile uploadFile = new JoUploadFile("http://" + server + "/sayfone/upload.php", "fileToUpload", model.getFile(), FileName);
        try {
            if (uploadFile.upload()) {
                PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
                pre.setString(1, FileName + "." + uploadFile.getExtension());
                pre.setInt(2, model.getFileTranferID());
                int state = pre.executeUpdate();
                System.out.println("file Delete " + model.getFileName());
                System.out.println("new file " + FileName + "." + uploadFile.getExtension());
                deleteFile(state, "http://" + server + "/sayfone/deletefile.php?filename=" + model.getFileName()); // ລົບໄຟເກົ່າ
                return state;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
            uploadFile.close();
        }
    }

    private void deleteFile(int state, String url) {
        if (state > 0) {
            JoHttp http = new JoHttp(url);
            http.Open();
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
        FileTranferModel model = new FileTranferModel(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), null, rs.getString(5));
        return model;
    }

}
