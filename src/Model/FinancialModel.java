package Model;

import java.sql.Date;

public class FinancialModel {

    private int FinancialIID;
    private int RegisterID;
    private int StudentID;
    private int Money;
    private int TransferMoney;
    private Date FinancialDate;
    private String FinancialMonth;
    private String FinancialComment;
    private int AuthenUserID;
    private int Discount;
    private int OvertimePay;
    private int UserID;
    private int foodMoney;
    private boolean state;

    public FinancialModel() {
    }

    public FinancialModel(int FinancialIID, int RegisterID, int StudentID, int Money, int TransferMoney, Date FinancialDate, String FinancialMonth, String FinancialComment, int AuthenUserID, int Discount, int OvertimePay, int UserID, int foodMoney, boolean state) {
        this.FinancialIID = FinancialIID;
        this.RegisterID = RegisterID;
        this.StudentID = StudentID;
        this.Money = Money;
        this.TransferMoney = TransferMoney;
        this.FinancialDate = FinancialDate;
        this.FinancialMonth = FinancialMonth;
        this.FinancialComment = FinancialComment;
        this.AuthenUserID = AuthenUserID;
        this.Discount = Discount;
        this.OvertimePay = OvertimePay;
        this.UserID = UserID;
        this.foodMoney = foodMoney;
        this.state = state;
    }

    public int getFinancialIID() {
        return FinancialIID;
    }

    public void setFinancialIID(int FinancialIID) {
        this.FinancialIID = FinancialIID;
    }

    public int getRegisterID() {
        return RegisterID;
    }

    public void setRegisterID(int RegisterID) {
        this.RegisterID = RegisterID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int Money) {
        this.Money = Money;
    }

    public int getTransferMoney() {
        return TransferMoney;
    }

    public void setTransferMoney(int TransferMoney) {
        this.TransferMoney = TransferMoney;
    }

    public Date getFinancialDate() {
        return FinancialDate;
    }

    public void setFinancialDate(Date FinancialDate) {
        this.FinancialDate = FinancialDate;
    }

    public String getFinancialMonth() {
        return FinancialMonth;
    }

    public void setFinancialMonth(String FinancialMonth) {
        this.FinancialMonth = FinancialMonth;
    }

    public String getFinancialComment() {
        return FinancialComment;
    }

    public void setFinancialComment(String FinancialComment) {
        this.FinancialComment = FinancialComment;
    }

    public int getAuthenUserID() {
        return AuthenUserID;
    }

    public void setAuthenUserID(int AuthenUserID) {
        this.AuthenUserID = AuthenUserID;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int Discount) {
        this.Discount = Discount;
    }

    public int getOvertimePay() {
        return OvertimePay;
    }

    public void setOvertimePay(int OvertimePay) {
        this.OvertimePay = OvertimePay;
    }

    public int getFoodMoney() {
        return foodMoney;
    }

    public void setFoodMoney(int foodMoney) {
        this.foodMoney = foodMoney;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

}
