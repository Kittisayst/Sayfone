package Model;

public class CountVillageModel {

    private String ProvinceName;
    private String DistrictName;
    private String VillageName;
    private int Count;

    public CountVillageModel(String ProvinceName, String DistrictName, String VillageName, int Count) {
        this.ProvinceName = ProvinceName;
        this.DistrictName = DistrictName;
        this.VillageName = VillageName;
        this.Count = Count;
    }

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String ProvinceName) {
        this.ProvinceName = ProvinceName;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String DistrictName) {
        this.DistrictName = DistrictName;
    }

    public String getVillageName() {
        return VillageName;
    }

    public void setVillageName(String VillageName) {
        this.VillageName = VillageName;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    @Override
    public String toString() {
        return "CountVillageModel{" + "ProvinceName=" + ProvinceName + ", DistrictName=" + DistrictName + ", VillageName=" + VillageName + ", Count=" + Count + '}';
    }

}
