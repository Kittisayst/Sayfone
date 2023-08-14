package DAOSevervice;

import DAO.FinancialDAO;
import Model.FinancialModel;
import Model.CreateRegisterModel;
import java.util.List;

public class FinancialService {

    private FinancialDAO aO = new FinancialDAO();

    public int Creater(FinancialModel model) {
        return aO.Creater(model);
    }

    public int Update(FinancialModel model) {
        return aO.Update(model);
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

    public List<FinancialModel> getFinancialReportByDate(String date) {
        return aO.getFinancialReportByDate(date);
    }

    public List<FinancialModel> getFinancialReportByWeek(String date) {
        return aO.getFinancialReportByWeek(date);
    }

    public List<FinancialModel> getFinancialReportByDateToDate(String startDate, String endDate) {
        return aO.getFinancialReportByDateToDate(startDate, endDate);
    }

    public List<FinancialModel> getFinancialReportByDateTransfer(String date) {
        return aO.getFinancialReportByDateTransfer(date);
    }

    public List<FinancialModel> getFinancialReportByWeekTransfer(String date) {
        return aO.getFinancialReportByWeekTransfer(date);
    }

    public List<FinancialModel> getFinancialReportByDateToDateTransfer(String startDate, String endDate) {
        return aO.getFinancialReportByDateToDateTransfer(startDate, endDate);
    }
    
    

    public String getLastClass(int StudentID) {
        return aO.getLastClass(StudentID);
    }

    public CreateRegisterModel getLastRegister(int studentID) {
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

}
