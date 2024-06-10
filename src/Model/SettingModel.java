package Model;

public class SettingModel {

    private int ID;
    private String Name;
    private String Value;

    public SettingModel() {
    }

    public SettingModel(int ID, String Name, String Value) {
        this.ID = ID;
        this.Name = Name;
        this.Value = Value;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    @Override
    public String toString() {
        return "SettingModel{" + "ID=" + ID + ", Name=" + Name + ", Value=" + Value + '}';
    }

}
