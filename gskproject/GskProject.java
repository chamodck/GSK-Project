package gskproject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import static mondrian.olap.Literal.one;

public class GskProject {

    static String currentUser="";//this is for get the curent user when log to the system
    static int currentUserID=-1;//this is for get the curent user ID when log to the system
    static int notiCount=0;//get the all notifications that received
    static int isAdmin=-1;
    
    //these two array lists hold popup notification message
    static ArrayList<ArrayList<Object>> popup=new ArrayList<ArrayList<Object>>();//popup the notification for admin
    static ArrayList<ArrayList<Object>> popupForAdmin=new ArrayList<ArrayList<Object>>();//popup the notification for other users
    DBOperations dbOps=new DBOperations();//create DbOperation object for check the current user
            
    public static void main(String[] args) {
        Login login = new Login();//login frame visible
        login.setVisible(true);
        //create thread for get updates from database
        /*create thread for get updates from database and the popu the notifications when loging to the system by particular */
        Thread one=new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (currentUser != "") {//when login to account,this if condition is true
                            if (isAdmin == 1) {//check logged user is admin or other user
                                //set the popup notifications
                                /*These string set for the popup notifications that received for the users when received 
                                a notification. There are 6 types of notifications can received to admin*/
                                String insert = "You are mention as responsible for the ObservationID : ";
                                String update = "Updated the Observation(as you responsible) : ";
                                String delete = "Deleted the Observation(as you responsible) : ";
                                String zapClose = "ZAP Closed of Observation(as you observer) : ";

                                String otherInsert = "Inserted new Observation : ";
                                String otherUpdate = "Updated the Observation : ";
                                String otherDelete = "Deleted the Observation : ";
                                String otherZapClose = "ZAP Closed of Observation : ";
                                //get observationID from table
                                popupForAdmin = DBOperations.getPopupAlertAsAdmin(currentUserID);
                                
                                //set the popup notifications
                                if (popupForAdmin != null) {//if the arraylist is not empty
                                    if (popupForAdmin.get(0).size() > 0) {//select the first index of the arraylist
                                        for (Object a : popupForAdmin.get(0)) {
                                            insert += a.toString() + ",";
                                        }
                                        insert += "\n";
                                    } else {
                                        insert = "";
                                    }
                                    if (popupForAdmin.get(1).size() > 0) {
                                        for (Object a : popupForAdmin.get(1)) {
                                            update += a.toString() + ",";
                                        }
                                        update += "\n";
                                    } else {
                                        update = "";
                                    }
                                    if (popupForAdmin.get(2).size() > 0) {
                                        for (Object a : popupForAdmin.get(2)) {
                                            delete += a.toString() + ",";
                                        }
                                        //insert +="/n";
                                    } else {
                                        delete = "";
                                    }
                                    if (popupForAdmin.get(3).size() > 0) {
                                        for (Object a : popupForAdmin.get(3)) {
                                            zapClose += a.toString() + ",";
                                        }
                                        zapClose += "\n";
                                    } else {
                                        zapClose = "";
                                    }
                                    if (popupForAdmin.get(4).size() > 0) {
                                        for (Object a : popupForAdmin.get(4)) {
                                            otherInsert += a.toString() + ",";
                                        }
                                        otherInsert += "\n";
                                    } else {
                                        otherInsert = "";
                                    }
                                    if (popupForAdmin.get(5).size() > 0) {
                                        for (Object a : popupForAdmin.get(5)) {
                                            otherUpdate += a.toString() + ",";
                                        }
                                        otherUpdate += "\n";
                                    } else {
                                        otherUpdate = "";
                                    }
                                    if (popupForAdmin.get(6).size() > 0) {
                                        for (Object a : popupForAdmin.get(6)) {
                                            otherDelete += a.toString() + ",";
                                        }
                                        otherDelete +="/n";
                                    }
                                    else {
                                        otherDelete = "";
                                    }
                                    if (popupForAdmin.get(7).size() > 0) {
                                        for (Object a : popupForAdmin.get(7)) {
                                            otherZapClose += a.toString() + ",";
                                        }
                                        //insert +="/n";
                                    }
                                    else {
                                        otherZapClose = "";
                                    }
                                    //popup nitification set visible
                                    /* create a object and popup notification set visible*/
                                    NotificationPopup popupWindow = new NotificationPopup();
                                    /*this will show the popup message if received any notifications that belongs to these 6 types.
                                        In here, call the popupMessage method written in the NotificationPopup class
                                    */
                                    popupWindow.popupMessage(insert + update + delete +zapClose+ otherInsert + otherUpdate + otherDelete+otherZapClose);
                                }
                                //get notification count for update notification button
                                notiCount = DBOperations.getNotiCountAsAdmin(currentUserID);
                                //set notification button text
                                if (notiCount > 0) {
                                    //set the notification button or count of total uncheked notifications
                                    MainFrame.btnNotification.setText("Notifications (" + notiCount + ")");
                                } else if (notiCount == 0) {
                                    //if there are no notifications it will just show this
                                    MainFrame.btnNotification.setText("Notifications");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error occured while getNotification count!");
                                }
                            } else {
                                //for other user
                                //notifications for other users. There are only three types of alerts
                                String insert = "You are mention as responsible for the ObservationID : ";
                                String update = "Updated the Observation : ";
                                String delete = "Deleted the Observation : ";
                                String zapClose = "Closed ZAP of Observation(as you Observer): ";

                                popup = DBOperations.getPopupAlertAsResponsible(currentUserID);
                                //this is for other users. just like create before for admin
                                if (popup != null) {
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
                                        insert +="/n";
                                    } else {
                                        delete = "";
                                    }
                                    if (popup.get(3).size() > 0) {
                                        for (Object a : popup.get(3)) {
                                            zapClose += a.toString() + ",";
                                            
                                        }
                                    } else {
                                        zapClose = "";
                                    }
                                    NotificationPopup popupWindow = new NotificationPopup();
                                    //display the notifications received for other users
                                    popupWindow.popupMessage(insert + update + delete+zapClose);
                                }
                                //total number of unread notification as a responsble party
                                notiCount = DBOperations.getNotiCountAsResponsible(currentUserID);

                                if (notiCount > 0) {
                                    //set the no of notifications that received for the user
                                    MainFrame.btnNotification.setText("Notifications (" + notiCount + ")");
                                } else if (notiCount == 0) {
                                    //if there are no new notifications then it will show just notification button
                                    MainFrame.btnNotification.setText("Notifications");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error occured while getNotification count!");
                                }
                                
                            }
                        
                        }
                        //thread sleep this number of miliseconds and run
                        Thread.sleep(1000);//thread sleep this number of miliseconds
                    }
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        one.start();//start the thread
    }
}
