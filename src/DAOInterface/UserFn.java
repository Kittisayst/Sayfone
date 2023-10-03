package DAOInterface;

import Model.UserModel;
import java.util.List;

public interface UserFn {

    public int CreateUser(UserModel userModel);

    public int UpdateUser(UserModel userModel);

    public int UpdateUserLogTime(UserModel userModel);

    public int DeleteUser(UserModel userModel);
    
    public boolean CheckAuthen(String authenText);

    public List<UserModel> getUserAll();

    public UserModel getUserById(int UserID);

    public UserModel UserLogin(String User, String Password);

    public UserModel getUserByAuthenKey(String authenKey);
}
