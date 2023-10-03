package DAOSevervice;

import DAO.UserDAO;
import Model.UserModel;
import java.util.List;

public class UserService {

    private final UserDAO userDAO = new UserDAO();

    public int CreateUser(UserModel userModel) {
        return userDAO.CreateUser(userModel);
    }

    public int UpdateUser(UserModel userModel) {
        return userDAO.UpdateUser(userModel);
    }

    public int DeleteUser(UserModel userModel) {
        return userDAO.DeleteUser(userModel);
    }

    public List<UserModel> getUserAll() {
        return userDAO.getUserAll();
    }

    public UserModel getUserById(int UserID) {
        return userDAO.getUserById(UserID);
    }

    public UserModel UserLogin(String User, String Password) {
        return userDAO.UserLogin(User, Password);
    }

    public int UpdateUserLogTime(UserModel userModel) {
        return userDAO.UpdateUserLogTime(userModel);
    }

    public UserModel getUserByAuthenKey(String authenKey) {
        return userDAO.getUserByAuthenKey(authenKey);
    }

    public boolean CheckAuthen(String authenText) {
        return userDAO.CheckAuthen(authenText);
    }

}
