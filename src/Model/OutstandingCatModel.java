package Model;

public class OutstandingCatModel {

    private int OutstandingCatID;
    private String OutstandingName;

    public int getOutstandingCatID() {
        return OutstandingCatID;
    }

    public void setOutstandingCatID(int OutstandingCatID) {
        this.OutstandingCatID = OutstandingCatID;
    }

    public String getOutstandingName() {
        return OutstandingName;
    }

    public void setOutstandingName(String OutstandingName) {
        this.OutstandingName = OutstandingName;
    }

    @Override
    public String toString() {
        return "OutstandingCatModel{" + "OutstandingCatID=" + OutstandingCatID + ", OutstandingName=" + OutstandingName + '}';
    }
    
    

}
