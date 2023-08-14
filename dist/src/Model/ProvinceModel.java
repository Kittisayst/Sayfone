package Model;



public class ProvinceModel {

    private int ProvinceID;
    private String ProvinceName;

    public ProvinceModel() {
    }

    public ProvinceModel(int ProvinceID, String ProvinceName) {
        this.ProvinceID = ProvinceID;
        this.ProvinceName = ProvinceName;
    }

    public int getProvinceID() {
        return ProvinceID;
    }

    public void setProvinceID(int ProvinceID) {
        this.ProvinceID = ProvinceID;
    }

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String ProvinceName) {
        this.ProvinceName = ProvinceName;
    }

}
