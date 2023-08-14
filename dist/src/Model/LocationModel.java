package Model;

public class LocationModel {

    private int AddressID;
    private int districtID;
    private int districtNowID;
    private int TeacherID;
    private String Village;
    private String VillageNow;

    public int getAddressID() {
        return AddressID;
    }

    public void setAddressID(int AddressID) {
        this.AddressID = AddressID;
    }

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    public int getDistrictNowID() {
        return districtNowID;
    }

    public void setDistrictNowID(int districtNowID) {
        this.districtNowID = districtNowID;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    public String getVillage() {
        return Village;
    }

    public void setVillage(String Village) {
        this.Village = Village;
    }

    public String getVillageNow() {
        return VillageNow;
    }

    public void setVillageNow(String VillageNow) {
        this.VillageNow = VillageNow;
    }

}
