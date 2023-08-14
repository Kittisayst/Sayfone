package DAOInterface;

import Model.BrotherAndSisterModel;
import java.util.List;

public interface BrotherAndSisterFN {

    public int CreaterBrotherAndSister(BrotherAndSisterModel model);

    public int UpdateBrotherAndSister(BrotherAndSisterModel model);

    public int DeleteBrotherAndSister(BrotherAndSisterModel model);

    public List<BrotherAndSisterModel> getBrotherAndSisterAll();

    public BrotherAndSisterModel getBrotherAndSisterById(int ID);

    public List<BrotherAndSisterModel> getBrotherSisterAll(int StudentID);

}
