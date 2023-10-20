package Model;

public class TeacherMoneyModel {

    private int TeacherMoneyID;
    private int TeacherID;
    private int Money;

    public TeacherMoneyModel() {
    }

    public TeacherMoneyModel(int TeacherMoneyID, int TeacherID, int Money) {
        this.TeacherMoneyID = TeacherMoneyID;
        this.TeacherID = TeacherID;
        this.Money = Money;
    }

    public int getTeacherMoneyID() {
        return TeacherMoneyID;
    }

    public void setTeacherMoneyID(int TeacherMoneyID) {
        this.TeacherMoneyID = TeacherMoneyID;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int Money) {
        this.Money = Money;
    }

    @Override
    public String toString() {
        return "TeacherMoneyModel{" + "TeacherMoneyID=" + TeacherMoneyID + ", TeacherID=" + TeacherID + ", Money=" + Money + '}';
    }

}
