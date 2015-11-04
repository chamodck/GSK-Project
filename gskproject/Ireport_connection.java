package gskproject;

import java.awt.Container;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class Ireport_connection extends JFrame{
   
    public Ireport_connection (String fileName,HashMap parameter){
        super("View Report");
        
        
        String url = "jdbc:mysql://localhost:3306/gskproject";
        String username = "root";
        String password = "";
        PreparedStatement pst = null;
        //Connection con = null;
        ResultSet rs;
       
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con =DriverManager.getConnection(url,username,password);
            System.out.println("connected to the database");
            JasperPrint print=JasperFillManager.fillReport(fileName, parameter,con);
            JRViewer viewer = new JRViewer(print);
            
            Container c =getContentPane();
            c.add(viewer);
            
        } catch (Exception ex) {
            Logger.getLogger(Ireport_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setBounds(10,10,1000,700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
   } 
    
   public static void main(String args[]) throws SQLException{
      
       Analyse_Main_GUI a =new Analyse_Main_GUI();
       a.setVisible(true);
       String query_total_reported= "select count(*) as x observation.observerID,user.username from observation INNER JOIN user ON (observation.observerID=user.userID) where (observation.observerID =" + "'" + "userid" + "'" + "or user.userName = " + "'" + "username" + "'" + ")";
       System.out.println(query_total_reported);
      
   }

}