package Model;

import View.DasboardView;
import View.HomeView;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class GlobalDataModel {

    //======== Model ========
    public static UserModel userModel;
    public static List<YearModel> yearModels;
    public static List<RegisterModel> registerModels;
    public static List<ClassModel> classModels;
    public static List<StudentModel> studentAll;
    public static List<FinancialModel> financialAll;
    public static DefaultTableModel TableStudentRegistered;
    //========= Variable ========
    public static boolean printerBillState;
    public static boolean printerReportState;
    //=========== View ==============
    public static HomeView rootView;
    public static DasboardView dasboardView;
    //setting
    public static SettingModel settingModel;

}
