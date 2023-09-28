package Model;

public class PermissionModel {

    private int PermissionID;
    private int UserID;
    private int type;
    private boolean state;

    public PermissionModel() {
    }

    public PermissionModel(int PermissionID, int UserID, int type, boolean state) {
        this.PermissionID = PermissionID;
        this.UserID = UserID;
        this.type = type;
        this.state = state;
    }

    public int getPermissionID() {
        return PermissionID;
    }

    public void setPermissionID(int PermissionID) {
        this.PermissionID = PermissionID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "PermissionModel{" + "PermissionID=" + PermissionID + ", UserID=" + UserID + ", type=" + type + ", state=" + state + '}';
    }
    
    
    
}
