package Utility;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class MyFormat {

    public String getDate(Date date) {
        String strDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return strDate;
    }

    public String getDate(java.util.Date date) {
        String strDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return strDate;
    }
    
    public String getTime(java.util.Date date,String pattern){
        String strDate = new SimpleDateFormat(pattern).format(date);
        return strDate;
    }

    public String getDateSQL(java.util.Date date) {
        String strDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return strDate;
    }

    public String getDateCustom(java.util.Date date, String format) {
        String strDate = new SimpleDateFormat(format).format(date);
        return strDate;
    }

    public java.sql.Date getSQLDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public String formatMoney(double money) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(money);
    }

    public double unFormatMoney(String money) {
        money = money.replace(",", "");
        double removeComma = Double.parseDouble(money.equals("") ? "0" : money);
        return removeComma;
    }

    public String formatMoney(String money) {
        money = money.replace(",", "");
        double removeComma = Double.parseDouble(money.equals("") ? "0" : money);
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(removeComma);
    }

}
