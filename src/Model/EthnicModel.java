package Model;

public class EthnicModel {

    private int EthnicID;
    private String EthnicName;

    public EthnicModel() {
    }

    public EthnicModel(int EthnicID, String EthnicName) {
        this.EthnicID = EthnicID;
        this.EthnicName = EthnicName;
    }

    public int getEthnicID() {
        return EthnicID;
    }

    public void setEthnicID(int EthnicID) {
        this.EthnicID = EthnicID;
    }

    public String getEthnicName() {
        return EthnicName;
    }

    public void setEthnicName(String EthnicName) {
        this.EthnicName = EthnicName;
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

}
