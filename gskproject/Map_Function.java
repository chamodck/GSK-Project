/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gskproject;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Malinda Ranabahu
 */
public class Map_Function extends javax.swing.JFrame {

    static int x, y;
    String color, map;
    static ImageIcon icon;
    static public Graphics2D g, end;
    static BufferedImage image, test;
    String acc;
    String quary;
    static Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs,r1 = null;
    String duration_variable;

    public Map_Function() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dname = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        accType = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtbox = new javax.swing.JTextField();
        ds = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        duration = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        dname.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "EHS", "IT", "Engineering" }));
        dname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnameActionPerformed(evt);
            }
        });

        jLabel2.setText("Deprtment");

        accType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "ALL", "LTI", "Near Miss", "First Aid" }));
        accType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accTypeActionPerformed(evt);
            }
        });

        jButton2.setText("Generate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Urdu Typesetting", 1, 18)); // NOI18N

        jLabel5.setText("Accident Type");

        txtbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtboxActionPerformed(evt);
            }
        });

        ds.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ds.setForeground(new java.awt.Color(255, 51, 51));

        jLabel6.setText("Select Duration");

        duration.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "ALL", "Last Week", "Last Month", "Last Year", "Last 5 Years" }));
        duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(dname, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(accType, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(21, 21, 21)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(91, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jButton2)
                .addGap(32, 32, 32)
                .addComponent(ds, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(227, 227, 227))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked


    }//GEN-LAST:event_jLabel1MouseClicked

    private void dnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnameActionPerformed
        map = dname.getSelectedItem().toString();
    }//GEN-LAST:event_dnameActionPerformed

    private void accTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accTypeActionPerformed
        acc = accType.getSelectedItem().toString();
        //System.out.println(color);
    }//GEN-LAST:event_accTypeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        ds.setText("");
        if (map == null) {
            ds.setText("Please Select the Department First");
        } else if (acc == null) {
            ds.setText("Please Select the Accident Type First");
        } else {
            try {
                ImportImage(map);        
                
                if (acc.equals("ALL")) {
                    quary = "SELECT x,y,accidentType From observation INNER JOIN department ON (observation.departmentID=department.departmentID) WHERE departmentName =" + "'" + map + "' and (observation.date >= " + "'" + duration_variable+ "'" + " )";
                } else {
                    quary = "SELECT x,y,accidentType From observation INNER JOIN department ON (observation.departmentID=department.departmentID) WHERE departmentName =" + "'" + map + "'" + " and accidentType =" + "'" + accType.getSelectedItem().toString() + "' and (observation.date >= " + "'" + duration_variable+ "'" + " )";
                }
                System.out.println(quary);
                pst = (PreparedStatement) con.prepareStatement(quary);
                rs = pst.executeQuery();
                r1=rs;
                
               if(!rs.next()){
                   ds.setText("You Selection Type have nothing to display");
               }
                rs = pst.executeQuery();
                String xcolor = "";
                while (rs.next()) {
                    int x = rs.getInt(1);
                    int y = rs.getInt(2);
                    String accidentType = rs.getString(3);

                    drawCircle(x - 5, y - 5, accidentType);
                }
               
            } catch (Exception ex) {    
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtboxActionPerformed

    private void durationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationActionPerformed
        Calculate_Duration d =new Calculate_Duration();
            if(duration.getSelectedItem()== "ALL"){
                duration_variable= d.get_Year(1000);
            }
            else if(duration.getSelectedItem()== "Last Week"){
                duration_variable= d.get_Date(1);
            }
            else if(duration.getSelectedItem()== "Last Month"){
                duration_variable= d.get_Month(1);
            }
            else if(duration.getSelectedItem()== "Last Year"){
                duration_variable=d.get_Year(1);
            }
            else if(duration.getSelectedItem()== "Last 5 Years"){
                duration_variable= d.get_Year(5);
            }
            else 
                duration_variable= d.get_Year(1000);
            
    }//GEN-LAST:event_durationActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Map_Function().setVisible(true);
                String url = "jdbc:mysql://localhost:3306/gskproject";//url=jdbc:mysql://hostname/ databaseName
                String username = "root";
                String password = "";
                String database = "gskproject";
                
                try {
                    con = DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Map_Function.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void drawCircle(int x, int y, String accidentType) {

        Graphics end = jLabel1.getGraphics();
        Graphics2D g1 = image.createGraphics();
        if (accidentType.equals("LTI")) {
            end.setColor(Color.yellow);
            end.fillOval(x, y, 10, 10);
            g1.setColor(Color.yellow);
            g1.fillOval(x, y - 32, 15, 15);
        } else if (accidentType.equals("First Aid")) {
            end.setColor(Color.red);
            end.fillOval(x, y, 10, 10);
            g1.setColor(Color.red);
            g1.fillOval(x, y - 32, 15, 15);
        } else if (accidentType.equals("Near Miss")) {
            end.setColor(Color.orange);
            end.fillOval(x, y, 10, 10);
            g1.setColor(Color.orange);
            g1.fillOval(x, y - 32, 15, 15);
        }
    }

    public void ImportImage(String map) throws IOException {
        if (map == null) {
            map = "EHS";
        }
        String xx = ("C:\\Users\\Malinda Ranabahu\\Desktop\\" + map + ".PNG");
        //System.out.println(xx);
        File imagefile = new File(xx);
        image = ImageIO.read(imagefile);
        Graphics2D g = image.createGraphics();
        ImageIcon icon = new ImageIcon(image);
        jLabel1.setIcon(icon);
        Graphics end = jLabel1.getGraphics();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accType;
    private javax.swing.JComboBox dname;
    private javax.swing.JLabel ds;
    private javax.swing.JComboBox duration;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtbox;
    // End of variables declaration//GEN-END:variables
}
