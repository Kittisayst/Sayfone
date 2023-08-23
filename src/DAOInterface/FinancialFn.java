package DAOInterface;

import Model.FinancialModel;
import Model.RegisterModel;
import java.util.List;

public interface FinancialFn {

    public int Creater(FinancialModel model);

    public int Update(FinancialModel model);

    public int Delete(FinancialModel model);

    public List<FinancialModel> getFinancialAll();

    public int getMaxFinancialID();

    public List<FinancialModel> getFinancialByStudentID(int RegisterID, int StudentID); // ດຶງຂໍ້ມູນເດຶອນຂອງນັກຮຽນທີ່ລົງທະບຽນໃນສົກປີ

    public List<FinancialModel> getStudentRegistered(int RegisterID);
    
        public List<FinancialModel> getSearchStudentRegistered(int RegisterID,String search);

    public FinancialModel getFinancialById(int ID);

    public List<FinancialModel> getFinancialReportByDate(String date, String userID); // ດຶງຂໍ້ມູນຈ່າຍຄ່າຮຽນປະຈຳວັນ ເງິນສົດ

    public List<FinancialModel> getFinancialReportByWeek(String date, String userID); // ດຶງຂໍ້ມູນຈ່າຍຄ່າຮຽນປະຈຳອາທິດ ເງິນສົດ

    public List<FinancialModel> getFinancialReportByDateToDate(String startDate, String endDate, String userID); //// ດຶງຂໍ້ມູນຈ່າຍຄ່າຮຽນປະຈຳວັນທີ ເງິນສົດ

    public List<FinancialModel> getFinancialReportByDateTransfer(String date, String userID); // ດຶງຂໍ້ມູນຈ່າຍຄ່າຮຽນປະຈຳວັນ ໂອນ

    public List<FinancialModel> getFinancialReportByWeekTransfer(String date, String userID); // ດຶງຂໍ້ມູນຈ່າຍຄ່າຮຽນປະຈຳ ອາທິດ ໂອນ

    public List<FinancialModel> getFinancialReportByDateToDateTransfer(String startDate, String endDate, String userID);

    public String getLastClass(int StudentID);

    public RegisterModel getLastRegister(int studentID);

    public String getPayMonth(int RegisterID, int StudentID);

    public int getCountFinancial();

    public List<FinancialModel> getFinancialFree(int YearID);// ຂໍ້ມຸນນັກຮຽນທີ່ລົງທະບຽນໃນສົກປີ

}
