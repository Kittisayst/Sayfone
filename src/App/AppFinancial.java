package App;

import Controller.FinancialController;
import DAOSevervice.ClassService;
import DAOSevervice.TimingSevervice;
import Log.JoLoger;
import Model.ClassModel;
import Model.RegisterModel;
import Model.StudentModel;
import Model.TimingModel;
import Tools.JoAlert;
import View.FinancialView;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AppFinancial {

    public AppFinancial(RegisterModel registerModel, StudentModel studentModel) {
        ZoneId laosTimeZone = ZoneId.of("Asia/Vientiane");
        // Get the current time in Laos
        LocalTime currentTimeInLaos = LocalTime.now(laosTimeZone);
        boolean hasPermission = checkPermission(currentTimeInLaos);
        if (hasPermission) {
            try {
                ClassModel classModel = new ClassService().getClassById(registerModel.getClassID());
                FinancialView view = new FinancialView(
                        "ຈ່າຍຄ່າຮຽນ: " + classModel.getClassName() + " ,  ຫ້ອງ: " + registerModel.getClassRoomName()
                        + " , " + studentModel.getFullName());
                FinancialController controller = new FinancialController(view, studentModel, registerModel);
                controller.Start();
                controller.AddEvent();
            } catch (Exception e) {
                JoLoger.saveLog(e, this);
                JoAlert.Error(e, this);
            }
        } else {
            TimingSevervice severvice = new TimingSevervice();
            TimingModel mstart = severvice.getTimingStart();
            TimingModel mstop = severvice.getTimingStop();
            String Start = mstart.getHour() + ":" + mstart.getMinute() + ":" + mstart.getSecond();
            String Stop = mstop.getHour() + ":" + mstop.getMinute() + ":" + mstop.getSecond();
            JoAlert alert = new JoAlert();
            alert.messages("ກຳນົດເວລາຈ່າຍຄ່າຮຽນ", "ປິດການຈ່າຍເງິນແລ້ວເລີ່ມໃໝ່ " + Start + " - " + Stop, JoAlert.Icons.warning);
        }

    }

    private boolean checkPermission(LocalTime currentTime) {
        TimingSevervice severvice = new TimingSevervice();
        TimingModel mstart = severvice.getTimingStart();
        TimingModel mstop = severvice.getTimingStop();
        //SET TIME START
        int START_HOUR = Integer.parseInt(mstart.getHour());
        int START_MINUTE = Integer.parseInt(mstart.getMinute());
        int START_SECOND = Integer.parseInt(mstart.getSecond());
        //SET TIME STOP
        int END_HOUR = Integer.parseInt(mstop.getHour());
        int END_MINUTE = Integer.parseInt(mstop.getMinute());
        int END_SECOND = Integer.parseInt(mstop.getSecond());
        //CREATE CALCULATE TIME
        LocalTime START_TIME = LocalTime.of(START_HOUR, START_MINUTE, START_SECOND);
        LocalTime END_TIME = LocalTime.of(END_HOUR, END_MINUTE, END_SECOND);
        return currentTime.isAfter(START_TIME) && currentTime.isBefore(END_TIME);
    }

}
