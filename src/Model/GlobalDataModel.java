package Model;

import View.DasboardView;
import View.HomeView;
import java.util.List;

public class GlobalDataModel {

    //======== Model ========
    public static UserModel userModel;
    public static List<YearModel> yearModels;
    public static List<RegisterModel> registerModels;
    public static List<ClassModel> classModels;
    public static List<StudentModel> studentAll;
    public static List<FinancialModel> financialAll;
    //========= Variable ========
    public static boolean printerBillState;
    public static boolean printerReportState;
    //=========== View ==============
    public static HomeView rootView;
    public static DasboardView dasboardView;

}
