package Model;

import DAOSevervice.YearService;

public class GobalData {

    public static int UserID;

    public static int getYearNow() {
        YearService service = new YearService();
        int lastID = service.getYearAll().size();
        return service.getYearAll().get(lastID - 1).getYearID();
    }
    
    
}
