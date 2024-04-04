package DAOSevervice;

import DAO.DocumentDAO;
import Model.DocumentModel;
import java.sql.ResultSet;
import java.util.List;

public class DocumentService {

    private DocumentDAO aO = new DocumentDAO();

    public int create(DocumentModel data) {
        return aO.create(data);
    }

    public DocumentModel read(int id) {
        return aO.read(id);
    }

    public int update(DocumentModel data) {
        return aO.update(data);
    }

    public int delete(int id) {
        return aO.delete(id);
    }

    public List<DocumentModel> getAll() {
        return aO.getAll();
    }

    public DocumentModel getResult(ResultSet rs) throws Exception {
        return aO.getResult(rs);
    }

    public List<DocumentModel> searchDoc(String text) {
        return aO.searchDoc(text);
    }

}
