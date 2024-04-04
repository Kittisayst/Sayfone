package DAO;

import DAOInterface.DAO;
import DAOSevervice.DocumentService;
import Database.JoConnect;
import Database.JoProperties;
import Database.JoSQL;
import Log.JoLoger;
import Main.JoUploadFile;
import Model.DocumentModel;
import Tools.JoAlert;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentDAO implements DAO<DocumentModel> {

    private String TableName = "tb_document";
    private JoProperties property = new JoProperties("/JoConfig/config.properties");
    private String server = property.getValueAt("db.Server");

    @Override
    public int create(DocumentModel data) {
        if (data.getImagePath().equals("")) {
            System.out.println("yes");
            return save(data);
        } else {
            JoUploadFile uploadImage = uploadImage(data);
            if (uploadImage.upload()) {
                String newImagePath = createFileName("img") + "." + uploadImage.getExtension();
                data.setImagePath(newImagePath);
                return save(data);
            } else {
                return 0;
            }
        }
    }

    @Override
    public DocumentModel read(int id) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        try {
            ResultSet rs = sql.getSelectById(id);
            if (rs.next()) {
                return getResult(rs);
            } else {
                return null;
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
            return null;
        } finally {
            connect.close();
        }
    }

    @Override
    public int update(DocumentModel model) {
        DocumentModel oldModel = new DocumentService().read(model.getDocumentID());
        System.out.println("send " + model);
        System.out.println("old " + oldModel);
        JoConnect connect = new JoConnect();
        boolean isImage = model.getImagePath().equals(oldModel.getImagePath());
        boolean isFile = model.getFilePath().equals(oldModel.getFilePath());
        try {
            if (!isFile) {
                updateDoc(model);
                System.out.println("updoc");
            }
            if (!isImage) {
                updateImage(model);
                System.out.println("upImg");
            }
            String sql = "UPDATE " + TableName + " SET title=?, comment=?, uploaddate=?, userID=? WHERE documentID=?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setString(1, model.getTitle());
            pre.setString(2, model.getComment());
            pre.setDate(3, model.getUploadDate());
            pre.setInt(4, model.getUserID());
            pre.setInt(5, model.getDocumentID());
            return pre.executeUpdate();
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
        return 0;
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
    public List<DocumentModel> getAll() {
        List<DocumentModel> models = new ArrayList<>();
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

    private int save(DocumentModel data) {
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), TableName);
        JoUploadFile uploadDoc = uploadDocument(data);
        try {
            if (uploadDoc.upload()) {
                String newPath = createFileName("doc") + "." + uploadDoc.getExtension();
                PreparedStatement pre = sql.setPrepared(sql.getCreate(),
                        data.getDocumentID(),
                        data.getTitle(),
                        data.getImagePath(),
                        newPath,
                        data.getFileName(),
                        data.getComment(),
                        data.getUploadDate(),
                        data.getUserID()
                );
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

    private JoUploadFile uploadImage(DocumentModel data) {
        System.out.println(data.getFileImage());
        JoUploadFile uploadImage = new JoUploadFile("http://" + server + "/sayfone/UploadDocument.php?folder=imageFile", "fileToUpload", data.getFileImage(), createFileName("img"));
        return uploadImage;
    }

    private JoUploadFile uploadDocument(DocumentModel data) {
        JoUploadFile uploadDoc = new JoUploadFile("http://" + server + "/sayfone/UploadDocument.php?folder=docFile", "fileToUpload", data.getFileDocument(), createFileName("doc"));
        return uploadDoc;
    }

    private void updateDoc(DocumentModel model) {
        JoConnect connect = new JoConnect();
        try {
            String sql = "UPDATE " + TableName + " SET filePath=?, fileName=? WHERE documentID=?";
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            JoUploadFile updoc = uploadDocument(model);
            if (updoc.upload()) {
                String newPath = createFileName("doc") + "." + updoc.getExtension();
                pre.setString(1, newPath);
                pre.setString(2, model.getFileName());
                pre.setInt(3, model.getDocumentID());
                pre.executeUpdate();
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
    }

    private void updateImage(DocumentModel model) {
        JoConnect connect = new JoConnect();
        try {
            JoUploadFile upImage = uploadImage(model);
            if (upImage.upload()) {
                String sql = "UPDATE " + TableName + " SET imagePath=? WHERE documentID=?";
                PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
                String newImagePath = createFileName("img") + "." + upImage.getExtension();
                pre.setString(1, newImagePath);
                pre.setInt(2, model.getDocumentID());
                pre.executeUpdate();
            }
        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
    }

    private int getMaxID() {
        JoConnect connect = new JoConnect();
        try {
            ResultSet rs = connect.getConnectionDefault().prepareStatement("SELECT COALESCE(MAX(documentID), 0) AS maxID FROM tb_document").executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
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

    private String createFileName(String title) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
        return getMaxID() + "-" + title + "-" + dateFormat.format(new Date());
    }

    public List<DocumentModel> searchDoc(String text) {
        JoConnect connect = new JoConnect();
        List<DocumentModel> models = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + TableName + " WHERE title LIKE '%" + text + "%'";
            ResultSet rs = connect.getConnectionDefault().createStatement().executeQuery(sql);
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
    public DocumentModel getResult(ResultSet rs) throws Exception {
        return new DocumentModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getInt(8), null, null);
    }

}
