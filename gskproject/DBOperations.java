package gskproject;

import com.mysql.jdbc.PreparedStatement;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

public class DBOperations {
    String url="jdbc:mysql://127.0.0.1:3306/gskproject?useUnicode=true&characterEncoding=utf-8";//url=jdbc:mysql://hostname/ databaseName
    String username="root";
    String password="";
    String database="gskproject";
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public Connection backupDB(){
        try{
            con=DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    
    public boolean addUser(User user){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="INSERT INTO user VALUES (?,?,?,?,?,?,?)";
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.setInt(1, user.getUserID());
            pst.setString(2,user.getUsername());
            pst.setString(3,user.getPassword());
            pst.setString(4,user.getDesignation());
            pst.setInt(5,user.getDepartmentID());
            pst.setString(6,user.getEmail());
            pst.setString(7,user.getMobileNumber());
            
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    int checkUsernamePassword(String username,String password){
        try {
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="SELECT username,password FROM user";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString(1).equals(username) & rs.getString(2).equals(password)){
                    return 1;//OK
                }
            }return 0;//Miss match
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;//Exception
        }finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }     
    }
    
    int updatePassword(String password,String username){
        try {
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="UPDATE user SET password='"+password+"' where username='"+username+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;//Exception
        }finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }    
    }
    
    int checkUsername(String username){
        try {
            con=DriverManager.getConnection(url, this.username, password);
            String quary="SELECT username FROM user";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            while(rs.next()){
                if(username.equals(rs.getString(1))){
                    return 1;
                }      
            }return 0;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
            
        }finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }       
    }
    
    int checkUsernameToUpdate(String username,int userID){
        try {
            con=DriverManager.getConnection(url, this.username, password);
            String quary="SELECT username,userID FROM user";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            while(rs.next()){
                if(username.equals(rs.getString(1)) ){
                    if(userID==rs.getInt(2)){
                        return 1;
                    }else{
                        return 0;
                    }
                }      
            }return 1;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
            
        }finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }       
    }
    
    ArrayList<User> getUser(){
        try {
            ArrayList<User> list=new ArrayList<User>();
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT * FROM user";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            while(rs.next()){
                User user=new User();
                user.setUserID(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setDesignation(rs.getString(4));
                user.setDepartmentID(rs.getInt(5));
                user.setEmail(rs.getString(6));
                user.setMobileNumber(rs.getString(7));
                
                list.add(user);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    ArrayList<User> getUser(int departmentID){
        try {
            ArrayList<User> list=new ArrayList<User>();
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT * FROM user WHERE departmentID="+departmentID;
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            while(rs.next()){
                User user=new User();
                user.setUserID(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setDesignation(rs.getString(4));
                user.setDepartmentID(rs.getInt(5));
                user.setEmail(rs.getString(6));
                user.setMobileNumber(rs.getString(7));
                
                list.add(user);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public boolean updateUser(User user){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="UPDATE user SET username='"+user.getUsername()+"',designation='"+user.getDesignation()+"',departmentID="+user.getDepartmentID()+",email='"+user.getEmail()+"',mobileNumber='"+user.getMobileNumber()+"' WHERE userID="+user.getUserID();
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public boolean deleteUser(User user){
        try {
            con = DriverManager.getConnection(url, username, password);
            String quary = "DELETE FROM user WHERE userID=" + user.getUserID();
            pst = (PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {

            try {
                if (pst != null) {
                    pst.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    
    
    public boolean resetPassword(User user){
        try {
            con = DriverManager.getConnection(url, username, password);
            
            
            String quary ="UPDATE user SET password='"+MD5.md5(Integer.toString(user.getUserID()))+"' WHERE username='"+user.getUsername()+"'";
            pst = (PreparedStatement)con.prepareStatement(quary);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {

            try {
                if (pst != null) {
                    pst.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public String getDepartmentName(int departmentID){
        try {
            con=DriverManager.getConnection(url, this.username, password);
            String quary="SELECT departmentName FROM department WHERE departmentID="+departmentID;
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            rs.next();
            return rs.getString(1);
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return "error";
    }
    
    public int isAdmin(){
        try {
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="SELECT designation,departmentID FROM user WHERE username='"+GskProject.currentUser+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            rs.next();
            if(rs.getString(1).equals("Manager") & rs.getInt(2)==1){
                return 1;
            }else{
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;//Exception
        }finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }     
    }
    
    public User getCurrentUser(){
        try {
            con = DriverManager.getConnection(url, username, password);
            String quary = "SELECT * FROM user WHERE username='" + GskProject.currentUser + "'";
            pst = (PreparedStatement) con.prepareStatement(quary);
            rs = pst.executeQuery();

            rs.next();
            User user = new User();
            user.setUserID(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setDesignation(rs.getString(4));
            user.setDepartmentID(rs.getInt(5));
            user.setEmail(rs.getString(6));
            user.setMobileNumber(rs.getString(7));
            return user;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public int getBackup(String path) {
        /*Used to create a cmd command*/
        //"C:\\wamp\\bin\\mysql\\mysql5.6.17\\bin\\mysqldump -u root -p gskproject -r C:\\Users\\chamod\\Documents\\backup\\backup1.sql"
        String executeCmd ="C:\\wamp\\bin\\mysql\\mysql5.6.17\\bin\\mysqldump.exe -u " + username + " -p " + password + " --add-drop-database -B " + database + " -r > "+ path;
         //"C:\\wamp\\bin\\mysql\\mysql5.6.17\\bin\\mysqldump -u " + username + " -p " + password + " " + "gskproject" +" > "+path;
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
 
            if (processComplete == 0) {
                return 1;
            } else {
                return 0;   
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 2;
           
        }
    }
    
    public int getLastObservationID(){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT observationID FROM observation";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            int id=0;
            if(rs.last()){
                id=rs.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            System.out.println(ex);
            return -1;
        }
        finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } 
    }
    
    public boolean addObservation(Observation ob){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="INSERT INTO observation (date,observationID,kindOfSource,observationType,description,departmentID,observerID,responsiblePartyID,zapStatus,x,y,accidentType,targetDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.setDate(1, (Date) ob.getDate());
            pst.setInt(2,ob.getObservationID());
            pst.setString(3,ob.getObservationType());
            pst.setString(4,ob.getKindOfSource());
            pst.setString(5,ob.getDescription());
            pst.setInt(6,ob.getDepartmentID());
            pst.setInt(7,ob.getObserverID());
            pst.setInt(8,ob.getResponsiblePartyID());
            pst.setString(9,ob.getZapStatus());
            pst.setInt(10, ob.getX());
            pst.setInt(11, ob.getY());
            pst.setString(12, ob.getAccidentType());
            pst.setDate(13, (Date) ob.getTargetDate());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public boolean addAction(Action action){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="INSERT INTO action VALUES (?,?,?,?,?)";
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.setInt(1,action.getActionID());
            pst.setString(2,action.getActionStatus());
            pst.setString(3,action.getActionDescription());
            pst.setInt(4,action.getObservationID());
            pst.setInt(5,action.getPriorityNumber());
            
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public Vector<Vector> getObservationOb(){
        try {
            con=DriverManager.getConnection(url, username, password);
            //User currentUser=this.getCurrentUser();
            String quary="SELECT * FROM observation WHERE observerID="+RelatedCases.currentUser.getUserID();
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            Vector<Vector> table=new Vector<Vector>();
            while(rs.next()){
                Vector<Object> row=new Vector<Object>();
                row.addElement(rs.getDate(1));
                row.addElement(rs.getInt(2));
                row.addElement(rs.getString(3));
                row.addElement(rs.getString(4));
                row.addElement(rs.getString(5));
                //row.addElement(rs.getInt(6));
                row.addElement(rs.getInt(8));
                row.addElement(rs.getString(9));
                row.addElement(rs.getDate(13));         
                table.add(row);
            }
            return table;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public Vector<Vector> getObservationRes(){
        try {
            con=DriverManager.getConnection(url, username, password);
            //User currentUser=this.getCurrentUser();
            String quary="SELECT * FROM observation WHERE responsiblePartyID="+RelatedCases.currentUser.getUserID();
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            Vector<Vector> table=new Vector<Vector>();
            while(rs.next()){
                Vector<Object> row=new Vector<Object>();
                row.addElement(rs.getDate(1));
                row.addElement(rs.getInt(2));
                row.addElement(rs.getString(3));
                row.addElement(rs.getString(4));
                row.addElement(rs.getString(5));
                //row.addElement(rs.getInt(6));
                row.addElement(rs.getInt(7));
                row.addElement(rs.getString(9));
                row.addElement(rs.getDate(13));
                //row.addElement(rs.getDate(11));
                //row.addElement(rs.getString(12));
                table.add(row);
            }
            return table;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public Vector<Vector> getAction(int obID){
        try {
            con=DriverManager.getConnection(url, username, password);
            //User currentUser=this.getCurrentUser();
            String quary="SELECT * FROM action WHERE observationID="+obID;
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            Vector<Vector> table=new Vector<Vector>();
            while(rs.next()){
                Vector<Object> row=new Vector<Object>();
                row.addElement(rs.getInt(1));
                row.addElement(rs.getString(3));
                row.addElement(rs.getString(2));
                row.addElement(rs.getInt(5));
                table.add(row);
            }
            return table;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } 
    }
    
    public int getDepartmentID(int observationID){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT departmentID FROM observation WHERE observationID="+observationID;
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            rs.next(); 
            return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex);
            return -1;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public String getAccidentType(int observationID){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT accidentType FROM observation WHERE observationID="+observationID;
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            rs.next(); 
            return rs.getString(1);
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public int[] getXY(int observationID){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT x,y FROM observation WHERE observationID="+observationID;
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            rs.next();
            
            int[] array=new int[2];
            array[0]=rs.getInt(1);
            array[1]=rs.getInt(2);
            return array;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public Vector<Vector> getObservation(){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT * FROM observation";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            Vector<Vector> table=new Vector<Vector>();
            while(rs.next()){
                Vector<Object> row=new Vector<Object>();
                row.addElement(rs.getDate(1));
                row.addElement(rs.getInt(2));
                row.addElement(rs.getString(3));
                row.addElement(rs.getString(4));
                row.addElement(rs.getString(5));
                row.addElement(rs.getInt(6));
                row.addElement(rs.getInt(7));
                row.addElement(rs.getInt(8));
                row.addElement(rs.getDate(9));
                row.addElement(rs.getDate(10));
                row.addElement(rs.getDate(11));
                row.addElement(rs.getString(12));
                row.addElement(rs.getInt(13));
                row.addElement(rs.getInt(14));
                row.addElement(rs.getString(15));
                table.add(row);
            }
            return table;    
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public Vector<Vector> getAnalyzeObservation(java.sql.Date from,java.sql.Date to){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="";
            if(from==null && to==null){
                quary="SELECT * FROM observation";
            }else if(to==null){
                quary="SELECT * FROM observation WHERE date >='"+from+"'";
            }else if(from==null){
                quary="SELECT * FROM observation WHERE date <='"+to+"'";
            }else{
                quary="SELECT * FROM observation WHERE (date BETWEEN '"+from+"' AND '"+to+"')";
            }
            
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            Vector<Vector> table=new Vector<Vector>();
            while(rs.next()){
                Vector<Object> row=new Vector<Object>();
                row.addElement(rs.getDate(1));
                row.addElement(rs.getInt(2));
                row.addElement(rs.getString(3));
                row.addElement(rs.getString(4));
                row.addElement(rs.getString(5));
                row.addElement(rs.getInt(6));
                row.addElement(rs.getInt(7));
                row.addElement(rs.getInt(8));
                row.addElement(rs.getString(9));
                row.addElement(rs.getInt(10));
                row.addElement(rs.getInt(11));
                row.addElement(rs.getString(12));
                row.addElement(rs.getDate(13));
                row.addElement(rs.getDate(14));
                table.add(row);
            }
            return table;    
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public ArrayList<String> getDepartmentNames(){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT departmentName FROM department";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            ArrayList<String> array=new ArrayList<String>();
            while(rs.next()){
                array.add(rs.getString(1));
            }
            return array;    
        }catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public ArrayList<Object[]> getDepartmentNameID(){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT * FROM department";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            ArrayList<Object[]> array=new ArrayList<Object[]>();
            while(rs.next()){
                Object[] row=new Object[2];
                row[0]=rs.getInt(1);
                row[1]=rs.getString(2);
                array.add(row);
            }
            return array;    
        }catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    public Vector<Vector> getEachPersonObservation(java.sql.Date from,java.sql.Date to,int userID){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="";
            if(from==null && to==null){
                quary="SELECT * FROM observation WHERE responsiblePartyID="+userID+" AND zapStatus='Close'";
            }else if(to==null){
                quary="SELECT * FROM observation WHERE date >='"+from+"' AND responsiblePartyID="+userID+" AND zapStatus='Close'";
            }else if(from==null){
                quary="SELECT * FROM observation WHERE date <='"+to+"' AND responsiblePartyID="+userID+" AND zapStatus='Close'";
            }else{
                quary="SELECT * FROM observation WHERE (date BETWEEN '"+from+"' AND '"+to+"') AND responsiblePartyID="+userID+" AND zapStatus='Close'";
            }
            
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            Vector<Vector> table=new Vector<Vector>();
            while(rs.next()){
                Vector<Object> row=new Vector<Object>();
                row.addElement(rs.getInt(2));
                row.addElement(rs.getDate(1));
                row.addElement(rs.getDate(14));
                table.add(row);
            }
            return table;    
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    
    
    public int getUserID(String username1){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT userID FROM user WHERE username='"+username1+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            rs.next(); 
            return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        }
        finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } 
    }
    
    public int updateAction(Action action){
        try {
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="UPDATE action SET actionStatus='"+action.getActionStatus()+"', actionDescription='"+action.getActionDescription()+"', priorityNumber="+action.getPriorityNumber()+" WHERE actionID="+action.getActionID();
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;//Exception
        }finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
}