package DAOInterface;

import Model.FileTranferModel;
import java.util.List;

public interface FileTransferFn {

    public int Creater(FileTranferModel model);

    public int Update(FileTranferModel model);

    public int Delete(FileTranferModel model);

    public List<FileTranferModel> getFileTranferAll();

    public FileTranferModel getFileTranferById(int ID);
    
    public FileTranferModel getFileTranferByFinancialID(int FinancialID);
}
