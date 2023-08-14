package DAOInterface;

import Model.DistrictModel;
import Model.TeacherAddressModel;
import java.util.List;

public interface TeacherAddressFn {

    public int CreaterTeacherAddress(TeacherAddressModel model);

    public int UpdateTeacherAddress(TeacherAddressModel model);

    public int DeleteTeacherAddress(TeacherAddressModel model);

    public List<TeacherAddressModel> getAllTeacherAddress();

    public TeacherAddressModel getTeacherAddressById(int TeacherID);
   
}
