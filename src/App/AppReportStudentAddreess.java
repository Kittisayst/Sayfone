package App;

import Controller.ReportStudentAddressController;
import View.ReportStudentAddressView;

public class AppReportStudentAddreess {

    private final ReportStudentAddressController controller;

    public AppReportStudentAddreess() {
        ReportStudentAddressView view = new ReportStudentAddressView("ລາຍງານສະຖິຕິທີ່ຢູ່ນັກຮຽນ");
        controller = new ReportStudentAddressController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
