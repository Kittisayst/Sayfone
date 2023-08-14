package Model;

public class YearModel {

    private int YearID;
    private String Year;

    public YearModel() {
    }

    public YearModel(int YearID, String Year) {
        this.YearID = YearID;
        this.Year = Year;
    }

    public int getYearID() {
        return YearID;
    }

    public void setYearID(int YearID) {
        this.YearID = YearID;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    @Override
    public String toString() {
        return "YearModel{" + "YearID=" + YearID + ", Year=" + Year + '}';
    }

}
