package DAOSevervice;

import DAO.StudentAddressDAO;
import Model.ChartStudentAddree;
import Model.StudentAddressModel;
import java.util.List;

public class StudentAddressService {

    StudentAddressDAO aO = new StudentAddressDAO();

    public int CreaterStudentLocation(StudentAddressModel model) {
        return aO.CreaterStudentLocation(model);
    }

    public int UpdateStudentLocation(StudentAddressModel model) {
        return aO.UpdateStudentLocation(model);
    }

    public int DeleteStudentLocation(StudentAddressModel model) {
        return aO.DeleteStudentLocation(model);
    }

    public List<StudentAddressModel> getAllStudentLocation() {
        return aO.getAllStudentLocation();
    }

    public StudentAddressModel getStudentLocationByStudentID(int StudentID) {
        return aO.getStudentLocationByStudentID(StudentID);
    }

    public List<ChartStudentAddree> getChartStudentAddressDistrict(boolean isDistrictNow) {
        return aO.getChartStudentAddressDistrict(isDistrictNow);
    }

    public List<ChartStudentAddree> getChartStudentProvince(boolean isDistrictNow) {
        return aO.getChartStudentProvince(isDistrictNow);
    }

}
