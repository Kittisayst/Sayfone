package DAOSevervice;

import DAO.FinancialDAO;
import Model.FinancialModel;
import java.util.List;

public class FinancialService {

    private FinancialDAO aO = new FinancialDAO();

    public int Creater(FinancialModel model) {
        return aO.Creater(model);
    }

    public int Update(FinancialModel model) {
        return aO.Update(model);
    }

    public int UpdateClassRoom(int RegisterOldClassID, int RegisterNewClassID, int StudentID) {
        return aO.UpdateClassRoom(RegisterOldClassID, RegisterNewClassID, StudentID);
    }

    public int Delete(FinancialModel model) {
        return aO.Delete(model);
    }

    public List<FinancialModel> getFinancialAll() {
        return aO.getFinancialAll();
    }

    public List<FinancialModel> getFinancialByStudentID(int RegisterID, int StudentID) {
        return aO.getFinancialByStudentID(RegisterID, StudentID);
    }

    public FinancialModel getFinancialById(int ID) {
        return aO.getFinancialById(ID);
    }

    public List<FinancialModel> getStudentRegistered(int RegisterID) {
        return aO.getStudentRegistered(RegisterID);
    }

    public List<FinancialModel> getFinancialReportByDate(String date, String userID) {
        return aO.getFinancialReportByDate(date, userID);
    }

    public List<FinancialModel> getFinancialReportByWeek(String date, String userID) {
        return aO.getFinancialReportByWeek(date, userID);
    }

    public List<FinancialModel> getFinancialReportByDateToDate(String startDate, String endDate, String userID) {
        return aO.getFinancialReportByDateToDate(startDate, endDate, userID);
    }

    public List<FinancialModel> getFinancialReportByDateTransfer(String date, String userID) {
        return aO.getFinancialReportByDateTransfer(date, userID);
    }

    public List<FinancialModel> getFinancialReportByWeekTransfer(String date, String userID) {
        return aO.getFinancialReportByWeekTransfer(date, userID);
    }

    public List<FinancialModel> getFinancialReportByDateToDateTransfer(String startDate, String endDate, String userID) {
        return aO.getFinancialReportByDateToDateTransfer(startDate, endDate, userID);
    }

    public String getLastClass(int StudentID) {
        return aO.getLastClass(StudentID);
    }

    public FinancialModel getLastRegister(int studentID) {
        return aO.getLastRegister(studentID);
    }

    public String getPayMonth(int RegisterID, int StudentID) {
        return aO.getPayMonth(RegisterID, StudentID);
    }

    public int getMaxFinancialID() {
        return aO.getMaxFinancialID();
    }

    public int getCountFinancial() {
        return aO.getCountFinancial();
    }

    public List<FinancialModel> getFinancialFree(int YearID) {
        return aO.getFinancialFree(YearID);
    }

    public List<FinancialModel> getSearchStudentRegistered(int RegisterID, String search) {
        return aO.getSearchStudentRegistered(RegisterID, search);
    }

    public int getUpdateWithdrawMonth(int FinancialID) {
        return aO.getUpdateWithdrawMonth(FinancialID);
    }

    public boolean getStudentIsReister(int StudentID) {
        return aO.getStudentIsReister(StudentID);
    }

}
