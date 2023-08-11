package Model;

import java.sql.Date;

public class UserModel extends TeacherModel {

    private int UserID;
    private String UserName;
    private String Password;
    private String UserLog;
    private Date Date;
    private String AuthenKey;

    public UserModel() {
    }

    public UserModel(int UserID, String UserName, String Password, String UserLog, Date Date, String AuthenKey) {
        this.UserID = UserID;
        this.UserName = UserName;
        this.Password = Password;
        this.UserLog = UserLog;
        this.Date = Date;
        this.AuthenKey = AuthenKey;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserLog() {
        return UserLog;
    }

    public void setUserLog(String UserLog) {
        this.UserLog = UserLog;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getAuthenKey() {
        return AuthenKey;
    }

    public void setAuthenKey(String AuthenKey) {
        this.AuthenKey = AuthenKey;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.UserID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserModel other = (UserModel) obj;
        if (this.UserID != other.UserID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserModel{" + "UserID=" + UserID + ", UserName=" + UserName + ", Password=" + Password + ", UserLog=" + UserLog + ", Date=" + Date + ", AuthenKey=" + AuthenKey + '}';
    }

 
}
