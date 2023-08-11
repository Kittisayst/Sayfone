package DAOSevervice;

import DAO.FileTransferDAO;
import Model.FileTranferModel;
import java.util.List;

public class FileTransferService {

    private FileTransferDAO aO = new FileTransferDAO();

    public int Creater(FileTranferModel model) {
        return aO.Creater(model);
    }

    public int Update(FileTranferModel model) {
        return aO.Update(model);
    }

    public int Delete(FileTranferModel model) {
        return aO.Delete(model);
    }

    public List<FileTranferModel> getFileTranferAll() {
        return aO.getFileTranferAll();
    }

    public FileTranferModel getFileTranferById(int ID) {
        return aO.getFileTranferById(ID);
    }

    public FileTranferModel getFileTranferByFinancialID(int FinancialID) {
        return aO.getFileTranferByFinancialID(FinancialID);
    }

}
