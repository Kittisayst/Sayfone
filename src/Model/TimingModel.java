package Model;

public class TimingModel {

    private int TimingID;
    private String Hour;
    private String Minute;
    private String Second;

    public TimingModel() {
    }

    public TimingModel(int TimingID, String Hour, String Minute, String Second) {
        this.TimingID = TimingID;
        this.Hour = Hour;
        this.Minute = Minute;
        this.Second = Second;
    }

    public int getTimingID() {
        return TimingID;
    }

    public void setTimingID(int TimingID) {
        this.TimingID = TimingID;
    }

    public String getHour() {
        return Hour;
    }

    public void setHour(String Hour) {
        this.Hour = Hour;
    }

    public String getMinute() {
        return Minute;
    }

    public void setMinute(String Minute) {
        this.Minute = Minute;
    }

    public String getSecond() {
        return Second;
    }

    public void setSecond(String Second) {
        this.Second = Second;
    }

    @Override
    public String toString() {
        return "TimingModel{" + "TimingID=" + TimingID + ", Hour=" + Hour + ", Minute=" + Minute + ", Second=" + Second + '}';
    }

}
