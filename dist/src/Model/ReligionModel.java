package Model;

public class ReligionModel {

    private int ReligionID;
    private String ReligionName;

    public ReligionModel() {
    }

    public ReligionModel(int ReligionID, String ReligionName) {
        this.ReligionID = ReligionID;
        this.ReligionName = ReligionName;
    }

    public int getReligionID() {
        return ReligionID;
    }

    public void setReligionID(int ReligionID) {
        this.ReligionID = ReligionID;
    }

    public String getReligionName() {
        return ReligionName;
    }

    public void setReligionName(String ReligionName) {
        this.ReligionName = ReligionName;
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

}
