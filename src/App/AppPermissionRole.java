package App;

import DAOSevervice.PermissionService;
import Model.GlobalDataModel;
import View.HomeView;

public class AppPermissionRole {

    private HomeView view;
    private PermissionService service = new PermissionService();

    public AppPermissionRole(HomeView view) {
        this.view = view;
    }

    public void Active() {
        view.getBtn_teacher().setVisible(isState(1));
        view.getBtn_Student().setVisible(isState(2));
        view.getBtnSubject().setVisible(isState(3));
        view.getBtnSubjectTeacher().setVisible(isState(4));
        view.getBtnClass().setVisible(isState(5));
        view.getBtnUser().setVisible(isState(6));
        view.getBtnPermission().setVisible(isState(7));
        view.getBtn_Register().setVisible(isState(8));
        view.getBtnFinancial().setVisible(isState(9));
        view.getBtnTeacherRank().setVisible(isState(10));
        view.getBtnAbsent().setVisible(isState(11));
        view.getBtnReportFinancial().setVisible(isState(12));
        view.getBtnReportUserFinancial().setVisible(isState(13));
        view.getBtnReportPay().setVisible(isState(14));
        view.getBtnFood().setVisible(isState(15));
        view.getBtnReportDiscount().setVisible(isState(16));
        view.getBtnWithdraw().setVisible(isState(17));
        view.getBtnReportTeacher().setVisible(isState(18));
        view.getBtnReportStudent().setVisible(isState(19));
        view.getBtnInfo().setVisible(isState(20));
        view.getBtnPrinter().setVisible(isState(21));
        view.getBtnReportTeacherMoney().setVisible(isState(23));
        view.getBtnBackup().setVisible(isState(24));
    }

    private boolean isState(int type) {
        return service.getRole(GlobalDataModel.userModel.getUserID(), type).isState();
    }
}
