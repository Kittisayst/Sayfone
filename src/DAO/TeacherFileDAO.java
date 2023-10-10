package DAO;

import DAOInterface.TeacherFileFn;
import Database.JoConnect;
import Database.JoProperties;
import Database.JoSQL;
import Log.JoLoger;
import Main.JoHttp;
import Main.JoUploadFile;
import Model.TeacherFileModel;
import java.util.List;
import Tools.JoAlert;
import Tools.JoFileSystem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TeacherFileDAO implements TeacherFileFn {

    private final String TableName = "tb_teacherfile";
    private final JoProperties property = new JoProperties("/JoConfig/config.properties");
    private final String server = property.getValueAt("db.Server");

    @Override
    public int CreaterTeacherFile(TeacherFileModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
        String FileName = model.getID() + "-" + dateFormat.format(new java.util.Date());
        JoUploadFile uploadFile = new JoUploadFile("http://" + server + "/sayfone/UploadFile.php", "fileToUpload", model.getFile(), FileName);
        try {
            if (uploadFile.upload()) {
                PreparedStatement pre = sql.setPrepared(sql.getCreate(),
                        model.getFileID(),
                        model.getID(),
                        FileName + "." + uploadFile.getExtension(),
                        model.getComments());
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
    public int UpdateTeacherFile(TeacherFileModel model) {
        JoConnect connect = new JoConnect();
        String sql = "UPDATE " + TableName + " SET comment=? WHERE teacherFileID=?";
        try {
            if (model.getFile() == null) {
                PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
                pre.setString(1, model.getComments());
                pre.setInt(2, model.getFileID());
                return pre.executeUpdate();
            } else {
                return UpdateImage(model);
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
    public int UpdateImage(TeacherFileModel model) {
        JoConnect connect = new JoConnect();
        try {
            String sql = "UPDATE " + TableName + " SET FileName=?, comment=? WHERE teacherFileID=?";
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
            String FileName = model.getID() + "-" + dateFormat.format(new java.util.Date());
            JoUploadFile uploadFile = new JoUploadFile("http://" + server + "/sayfone/UploadFile.php", "fileToUpload", model.getFile(), FileName);
            if (uploadFile.upload()) {
                PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
                pre.setString(1, FileName + "." + uploadFile.getExtension());
                pre.setString(2, model.getComments());
                pre.setInt(3, model.getFileID());
                int state = pre.executeUpdate();
                System.out.println(model);
                deleteFile(state, "http://" + server + "/sayfone/deletefile.php?folder=UploadFile&filename=" + model.getFlieName()); // ລົບໄຟເກົ່າ
                return state;
            } else {
                return 0;
            }
        } catch (SQLException e) {
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
    public int DeleteTeacherFile(TeacherFileModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getDelete();
            pre.setInt(1, model.getFileID());
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
    public List<TeacherFileModel> getAllTeacherFileByTeacherID(int TeacherFileID) {
        List<TeacherFileModel> fileModels = new ArrayList<>();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getSelectCustom("TeacherID=?");
            pre.setInt(1, TeacherFileID);
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
    public TeacherFileModel getTeacherFileById(int TeacherFileID) {
        TeacherFileModel fileModel = new TeacherFileModel();
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            PreparedStatement pre = sql.getSelectCustom("TeacherID=?");
            pre.setInt(1, TeacherFileID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
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

    @Override
    public boolean CreatePDF(TeacherFileModel model) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectById(model.getFileID());
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

    public TeacherFileModel getResult(ResultSet rs) throws Exception {
        return new TeacherFileModel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), null);
    }

}
