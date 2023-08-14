package DAO;

import DAOInterface.TeacherFileFn;
import Database.JoConnect;
import Model.TeacherFileModel;
import java.util.List;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Utility.JoBlobConvert;
import Utility.SayfoneFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherFileDAO implements TeacherFileFn {

    private final Connection c = new JoConnect().getConnectionDefault();
    private final String TableName = "tb_teacherfile";
    private final String SQL_Create = "INSERT INTO " + TableName + " VALUES(?,?,?,?,?)";
    private final String SQL_Update = "UPDATE " + TableName + " SET teacherFileName=?,comment=? WHERE teacherFileID=?";
    private final String SQL_Delete = "DELETE FROM " + TableName + " WHERE teacherFileID=?";
    private final String SQL_GET_All_ByTeacehrID = "SELECT * FROM " + TableName + " WHERE TeacherID=?";
    private final String SQL_GET_ById = "SELECT * FROM " + TableName + " WHERE teacherFileID=?";
    private final String SQL_UpdateImage = "UPDATE " + TableName + " SET File=? WHERE teacherFileID=?";

    @Override
    public int CreaterTeacherFile(TeacherFileModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Create);
            pre.setString(1, null);
            pre.setInt(2, model.getTeacherID());
            pre.setString(3, model.getFlieName());
            InputStream in = new JoBlobConvert(model.getLocalFile()).getFileInput();
            pre.setBinaryStream(4, in, in.available());
            pre.setString(5, model.getComments());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public int UpdateTeacherFile(TeacherFileModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Update);
            pre.setString(1, model.getFlieName());
            pre.setString(2, model.getComments());
            pre.setInt(3, model.getTeacherFileID());
            if (model.getLocalFile() != null) {
                UpdateImage(model);
            }
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public void UpdateImage(TeacherFileModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_UpdateImage);
            InputStream in = new JoBlobConvert(model.getLocalFile()).getFileInput();
            pre.setBinaryStream(1, in, in.available());
            pre.setInt(2, model.getTeacherFileID());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
    }

    @Override
    public int DeleteTeacherFile(TeacherFileModel model) {
        try {
            PreparedStatement pre = c.prepareStatement(SQL_Delete);
            pre.setInt(1, model.getTeacherFileID());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
            return 0;
        }
    }

    @Override
    public List<TeacherFileModel> getAllTeacherFileByTeacherID(int TeacherFileID) {
        List<TeacherFileModel> models = new ArrayList<>();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_All_ByTeacehrID);
            pre.setInt(1, TeacherFileID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                TeacherFileModel model = new TeacherFileModel();
                model.setTeacherFileID(rs.getInt(1));
                model.setTeacherID(rs.getInt(2));
                model.setFlieName(rs.getString(3));
                model.setFile(rs.getBlob(4));
                model.setComments(rs.getString(5));
                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return models;
    }

    @Override
    public TeacherFileModel getTeacherFileById(int TeacherFileID) {
        TeacherFileModel model = new TeacherFileModel();
        try {
            PreparedStatement pre = c.prepareStatement(SQL_GET_ById);
            pre.setInt(1, TeacherFileID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                model.setTeacherFileID(rs.getInt(1));
                model.setTeacherID(rs.getInt(2));
                model.setFlieName(rs.getString(3));
                model.setFile(rs.getBlob(4));
                model.setComments(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return model;
    }

    @Override
    public void CreatePDF(TeacherFileModel model) {
        JoFileSystem fileSystem = new JoFileSystem();
        String fileEx = fileSystem.getCurrentPath() + "/" + SayfoneFile.TeacherFolder + "/example.pdf";
        FileOutputStream output = null;
        try {
            if (model.getFile() != null) {
                output = new FileOutputStream(fileEx);
                byte[] buffer = new byte[1];
                InputStream input = model.getFile().getBinaryStream();
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
                fileSystem.OpenFile(new File(fileEx));
            } else {
                new JoAlert().messages("ເອກະສານ", "ພໍ່ພົບຂໍ້ມູນເອກະສານ", "warning");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TeacherFileModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(TeacherFileModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (model.getFile() != null) {
                    output.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(TeacherFileModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
