package gskproject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import static mondrian.olap.Literal.one;

public class GskProject {

    static String currentUser="";
    static int currentUserID=-1;
    
    static ArrayList<ArrayList<Object>> popup=new ArrayList<ArrayList<Object>>();
    DBOperations dbOps=new DBOperations();
            
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        
        Thread one=new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {                        
                        
                        if(currentUser!=""){
                            String insert="You are mention as responsible for the ObservationID : ";
                            String update="Updated the Observation : ";
                            String delete="Deleted the Observation : ";
                            
                            popup=DBOperations.getPopupAlertAsResponsible(currentUserID);
                            //System.out.println(popup.size());
                            if (popup!=null) {
                                if (popup.get(0).size() > 0) {
                                    for (Object a : popup.get(0)) {
                                        insert += a.toString() + ",";
                                    }
                                    insert += "\n";
                                } else {
                                    insert = "";
                                }
                                if (popup.get(1).size() > 0) {
                                    for (Object a : popup.get(1)) {
                                        update += a.toString() + ",";
                                    }
                                    update += "\n";
                                } else {
                                    update = "";
                                }
                                if (popup.get(2).size() > 0) {
                                    for (Object a : popup.get(2)) {
                                        delete += a.toString() + ",";
                                    }
                                    //insert +="/n";
                                } else {
                                    delete = "";
                                }
                                NotificationPopup popupWindow = new NotificationPopup();
                                popupWindow.popupMessage(insert+update+delete);
                            }
                            //System.out.println("sfgdgfh");
                        }
                        Thread.sleep(15000);
                    }
                     // time after which pop up will be disappeared.
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        one.start();
    }
}
