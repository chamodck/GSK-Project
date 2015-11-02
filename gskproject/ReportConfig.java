/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gskproject;

import static gskproject.Analyze.para;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author chamod
 */
public class ReportConfig {
    
    String url="jdbc:mysql://127.0.0.1:3306/gskproject?useUnicode=true&characterEncoding=utf-8";//url=jdbc:mysql://hostname/ databaseName
    String username="root";
    String password="";
    String database="gskproject";
    
    void generateReport(String path,HashMap<String,Object> para){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, username, password);
            //JasperDesign jasperDesign=Jasper
            JasperReport jc=JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(jc,para,new JREmptyDataSource());
            JasperViewer.viewReport(print);
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
