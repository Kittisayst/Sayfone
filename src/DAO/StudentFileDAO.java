package DAO;

import DAOInterface.DAO;
import Database.JoConnect;
import Database.JoProperties;
import Database.JoSQL;
import Log.JoLoger;
import Main.JoHttp;
import Main.JoUploadFile;
import Model.StudentFileModel;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Utility.MyFormat;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StudentFileDAO implements DAO<StudentFileModel> {

    private final String TableName = "tb_studentfile";
    private JoProperties property = new JoProperties("/JoConfig/config.properties");
    private String server = property.getValueAt("db.Server");

    @Override
    public int create(StudentFileModel data) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
        String FileName = data.getStudentID() + "-" + dateFormat.format(new java.util.Date());
        JoUploadFile uploadFile = new JoUploadFile("http://" + server + "/sayfone/UploadFile.php", "fileToUpload", data.getFile(), FileName);
        try {
            if (uploadFile.upload()) {
                PreparedStatement pre = sql.setPrepared(sql.getCreate(),
                        data.getFileID(),
                        data.getStudentID(),
                        FileName + "." + uploadFile.getExtension(),
                        data.getSaveDate(),
                        data.getComment());
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
        }
    }

    @Override
    public StudentFileModel read(int id) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        StudentFileModel fileModel = new StudentFileModel();
        try {
            ResultSet rs = sql.getSelectById(id);
            if (rs.next()) {
                fileModel = getResult(rs);
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return fileModel;
    }

    public boolean openFile(int id) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectById(id);
            if (rs.next()) {
                String savePath = new JoFileSystem().getUserPath() + "/Downloads/" + rs.getString(3);
                String fileUrl = "http://" + server + "/sayfone/LoadFile.php?fileName=" + rs.getString(3);
                boolean state = new JoHttp().DownloadFile(fileUrl, rs.getString(3), savePath);
                if (state) {
                    JoFileSystem fileSystem = new JoFileSystem();
                    fileSystem.OpenFile(savePath);
                }
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return true;
    }

    @Override
    public int update(StudentFileModel data) {
        JoConnect connect = new JoConnect();
        String sql = "UPDATE " + TableName + " SET comment=? WHERE FileID=?";
        try {
            if (data.getFile() == null) {
                PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
                pre.setString(1, data.getComment());
                pre.setInt(2, data.getFileID());
                return pre.executeUpdate();
            } else {
                return updateImage(data);
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return 0;
        } finally {
            connect.close();
        }
    }

    private int updateImage(StudentFileModel data) {
        JoConnect connect = new JoConnect();
        try {
            String sql = "UPDATE " + TableName + " SET FileName=?,SaveDate=?,comment=? WHERE FileID=?";
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
            String FileName = data.getStudentID() + "-" + dateFormat.format(new java.util.Date());
            JoUploadFile uploadFile = new JoUploadFile("http://" + server + "/sayfone/UploadFile.php", "fileToUpload", data.getFile(), FileName);
            if (uploadFile.upload()) {
                PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
                pre.setString(1, FileName + "." + uploadFile.getExtension());
                pre.setDate(2, new MyFormat().getSQLDate(new java.util.Date()));
                pre.setString(3, data.getComment());
                pre.setInt(4, data.getFileID());
                 int state = pre.executeUpdate();
                 deleteFile(state, "http://" + server + "/sayfone/deletefile.php?folder=UploadFile&filename=" + data.getFileName()); // ລົບໄຟເກົ່າ
                return state;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.err.println(e);
            return 0;
        }
    }

    private void deleteFile(int state, String url) {
        if (state > 0) {
            JoHttp http = new JoHttp(url);
            http.Open();
        }
    }

    @Override
    public int delete(int id) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, id);
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
    public List<StudentFileModel> getAll() {
        List<StudentFileModel> fileModels = new ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                fileModels.add(getResult(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return fileModels;
    }

    public List<StudentFileModel> getByStudentID(int ID) {
        List<StudentFileModel> fileModels = new ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getSelectCustom("StudentID=?");
            pre.setInt(1, ID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                fileModels.add(getResult(rs));
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return fileModels;
    }

    @Override
    public StudentFileModel getResult(ResultSet rs) throws Exception {
        return new StudentFileModel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getString(5), null);
    }

}
