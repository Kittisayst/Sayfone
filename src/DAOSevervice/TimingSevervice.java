package DAOSevervice;

import DAO.TimingDAO;
import Model.TimingModel;
import java.sql.ResultSet;
import java.util.List;

public class TimingSevervice {

    private TimingDAO aO = new TimingDAO();

    public int create(TimingModel data) {
        return aO.create(data);
    }

    public TimingModel read(int id) {
        return aO.read(id);
    }

    public TimingModel getTimingStart() {
        return aO.getTimingStart();
    }

    public TimingModel getTimingStop() {
        return aO.getTimingStop();
    }

    public int update(TimingModel data) {
        return aO.update(data);
    }

    public int UpdateTime(int ID, String Timestart, String Timestop) {
        return aO.UpdateTime(ID, Timestart, Timestop);
    }

    public int delete(int id) {
        return aO.delete(id);
    }

    public List<TimingModel> getAll() {
        return aO.getAll();
    }

    public TimingModel getResult(ResultSet rs) throws Exception {
        return aO.getResult(rs);
    }

}
