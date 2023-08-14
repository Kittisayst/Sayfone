package Utility;

import Tools.JoAlert;
import java.util.logging.Level;

public class Alert {

    public static void ShowError(Object Class,Exception e) {
//        UserController.class.getName()
        new JoAlert().messages("Error", "ລະຫັດ: " +"Sever: "+ Level.SEVERE+"Warning: "+ Level.ALL + Class.getClass().getName()+" ລາຍລະອຽດ: "+e, "error");
        System.out.println(Level.ALL+" ລາຍລະອຽດ: "+e);
    }
}
