package Model;

import java.sql.Date;

public class FoodPaymentModel {

    private int FoodPaymentID;
    private int RegisterID;
    private int StudentID;
    private String Months;
    private int Price;
    private String Comment;
    private Date SaveDate;
    private int UserID;

    public FoodPaymentModel() {
    }

    public FoodPaymentModel(int FoodPaymentID, int RegisterID, int StudentID, String Months, int Price, String Comment, Date SaveDate, int UserID) {
        this.FoodPaymentID = FoodPaymentID;
        this.RegisterID = RegisterID;
        this.StudentID = StudentID;
        this.Months = Months;
        this.Price = Price;
        this.Comment = Comment;
        this.SaveDate = SaveDate;
        this.UserID = UserID;
    }

    public int getFoodPaymentID() {
        return FoodPaymentID;
    }

    public void setFoodPaymentID(int FoodPaymentID) {
        this.FoodPaymentID = FoodPaymentID;
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

    public String getMonths() {
        return Months;
    }

    public void setMonths(String Months) {
        this.Months = Months;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public Date getSaveDate() {
        return SaveDate;
    }

    public void setSaveDate(Date SaveDate) {
        this.SaveDate = SaveDate;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    @Override
    public String toString() {
        return "FoodPaymentModel{" + "FoodPaymentID=" + FoodPaymentID + ", RegisterID=" + RegisterID + ", StudentID=" + StudentID + ", Months=" + Months + ", Price=" + Price + ", Comment=" + Comment + ", SaveDate=" + SaveDate + ", UserID=" + UserID + '}';
    }

}
