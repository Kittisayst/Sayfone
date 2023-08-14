package DAOInterface;

import Model.StudentAddressModel;
import java.util.List;

public interface StudentAddressFn {

    public int CreaterStudentLocation(StudentAddressModel model);

    public int UpdateStudentLocation(StudentAddressModel model);

    public int DeleteStudentLocation(StudentAddressModel model);

    public List<StudentAddressModel> getAllStudentLocation();

    public StudentAddressModel getStudentLocationByStudentID(int StudentID);
}
