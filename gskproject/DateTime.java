package gskproject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    public static String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    public static String getTime(){
        DateFormat dateFormat = new SimpleDateFormat("HH.mm.ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    public static String getDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd - HH.mm.ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
