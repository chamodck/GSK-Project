/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gskproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Case_Summary {
    String getData(String quary) throws SQLException{
      int count;
        
            
            
           String url = "jdbc:mysql://localhost:3306/gskproject?useUnicode=true&characterEncoding=utf-8";
            String username = "root";
            String password = "";
            PreparedStatement pst = null;
            Connection con = null;
            ResultSet rs;
            
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            Logger.getLogger(Case_Summary.class.getName()).log(Level.SEVERE, null, ex);
        }
            con=DriverManager.getConnection(url, username, password);
            //String quary0="select count(*) as x from observation where accidentType=";
            //String quary1="'" + "EHS" +"'";
            //String quary =quary0.concat(quary1);
           
            pst=(com.mysql.jdbc.PreparedStatement)con.prepareStatement(quary);
            rs = pst.executeQuery(quary);
            rs.next();
            count=rs.getInt("x");
            String countt= Integer.toString(count);
            System.out.println(count);
            pst.close();
            //System.out.println(count);
            
            /*while (rs.next())
            {
            int id = rs.getInt("actionID");
            String departmentName = rs.getString("actionStatus");
            String actionStatus= rs.getString("actionStatus");
            String actionDescription=rs.getString("actionDescription");
            int observationID=rs.getInt("observationID");
            int priorityNumber=rs.getInt("priorityNumber");
            System.out.format("%d, %s\n", id,departmentName);
            }*/
            
            
       
         return countt; 
  }
}
