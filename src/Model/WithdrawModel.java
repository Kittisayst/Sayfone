package Model;

public class WithdrawModel {

    private int WithdrawID;
    private int finacialID;
    private int money;
    private int transferMoney;
    private String WithdrawDate;
    private int userID;
    private int userAuthen;
    private String withdrawComment;

    public WithdrawModel() {
    }

    public WithdrawModel(int WithdrawID, int finacialID, int money, int transferMoney, String WithdrawDate, int userID, int userAuthen, String withdrawComment) {
        this.WithdrawID = WithdrawID;
        this.finacialID = finacialID;
        this.money = money;
        this.transferMoney = transferMoney;
        this.WithdrawDate = WithdrawDate;
        this.userID = userID;
        this.userAuthen = userAuthen;
        this.withdrawComment = withdrawComment;
    }

    public int getWithdrawID() {
        return WithdrawID;
    }

    public void setWithdrawID(int WithdrawID) {
        this.WithdrawID = WithdrawID;
    }

    public int getFinacialID() {
        return finacialID;
    }

    public void setFinacialID(int finacialID) {
        this.finacialID = finacialID;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getTransferMoney() {
        return transferMoney;
    }

    public void setTransferMoney(int transferMoney) {
        this.transferMoney = transferMoney;
    }

    public String getWithdrawDate() {
        return WithdrawDate;
    }

    public void setWithdrawDate(String WithdrawDate) {
        this.WithdrawDate = WithdrawDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserAuthen() {
        return userAuthen;
    }

    public void setUserAuthen(int userAuthen) {
        this.userAuthen = userAuthen;
    }

    public String getWithdrawComment() {
        return withdrawComment == null ? "ບໍ່ມີ" : withdrawComment;
    }

    public void setWithdrawComment(String withdrawComment) {
        this.withdrawComment = withdrawComment;
    }

    @Override
    public String toString() {
        return "WithdrawModel{" + "WithdrawID=" + WithdrawID + ", finacialID=" + finacialID + ", money=" + money + ", transferMoney=" + transferMoney + ", WithdrawDate=" + WithdrawDate + ", userID=" + userID + ", userAuthen=" + userAuthen + ", withdrawComment=" + withdrawComment + '}';
    }

}
