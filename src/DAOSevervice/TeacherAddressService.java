package DAOSevervice;

import DAO.TeacherAddressDAO;
import Model.TeacherAddressModel;
import java.util.List;

public class TeacherAddressService {

    private final TeacherAddressDAO aO = new TeacherAddressDAO();

    public int CreaterTeacherAddress(TeacherAddressModel model) {
        return aO.CreaterTeacherAddress(model);
    }

    public int UpdateTeacherAddress(TeacherAddressModel model) {
        return aO.UpdateTeacherAddress(model);
    }

    public int DeleteTeacherAddress(TeacherAddressModel model) {
        return aO.DeleteTeacherAddress(model);
    }

    public List<TeacherAddressModel> getAllTeacherAddress() {
        return aO.getAllTeacherAddress();
    }

    public TeacherAddressModel getTeacherAddressById(int TeacherAddressID) {
        return aO.getTeacherAddressById(TeacherAddressID);
    }

}
