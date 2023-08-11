package Model;

public class NationalityModel {

    private int NationalityID;
    private String NationalityName;

    public NationalityModel() {
    }

    public NationalityModel(int NationalityID, String NationalityName) {
        this.NationalityID = NationalityID;
        this.NationalityName = NationalityName;
    }

    public int getNationalityID() {
        return NationalityID;
    }

    public void setNationalityID(int NationalityID) {
        this.NationalityID = NationalityID;
    }

    public String getNationalityName() {
        return NationalityName;
    }

    public void setNationalityName(String NationalityName) {
        this.NationalityName = NationalityName;
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

}
