package Model;

import java.sql.Date;

public class TeacherMoneyModel {

    private int TeacherMoneyID;
    private int TeacherID;
    private int Balance;
    private Date SaveDate;
    private String Code;
    private int Withdraw;
    private int Deposit;
    private String Comment;
    private int UserID;

    public TeacherMoneyModel() {
    }

    public TeacherMoneyModel(int TeacherMoneyID, int TeacherID, int Balance, Date SaveDate, String Code, int Withdraw, int Deposit, String Comment, int UserID) {
        this.TeacherMoneyID = TeacherMoneyID;
        this.TeacherID = TeacherID;
        this.Balance = Balance;
        this.SaveDate = SaveDate;
        this.Code = Code;
        this.Withdraw = Withdraw;
        this.Deposit = Deposit;
        this.Comment = Comment;
        this.UserID = UserID;
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

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }

    public Date getSaveDate() {
        return SaveDate;
    }

    public void setSaveDate(Date SaveDate) {
        this.SaveDate = SaveDate;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public int getWithdraw() {
        return Withdraw;
    }

    public void setWithdraw(int Withdraw) {
        this.Withdraw = Withdraw;
    }

    public int getDeposit() {
        return Deposit;
    }

    public void setDeposit(int Deposit) {
        this.Deposit = Deposit;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    @Override
    public String toString() {
        return "TeacherMoneyModel{" + "TeacherMoneyID=" + TeacherMoneyID + ", TeacherID=" + TeacherID + ", Balance=" + Balance + ", SaveDate=" + SaveDate + ", Code=" + Code + ", Withdraw=" + Withdraw + ", Deposit=" + Deposit + ", Comment=" + Comment + ", UserID=" + UserID + '}';
    }

}
