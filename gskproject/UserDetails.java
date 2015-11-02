package gskproject;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class UserDetails extends AbstractTableModel{
   
    public static final String[] COLUMN_NAME={"User ID","Name","Department","Designation","Email","Mobile Number"};
    public static ArrayList<User> list;
    DBOperations dbOps=new DBOperations();
    
    UserDetails(ArrayList<User> userList){
        list=userList;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAME.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return COLUMN_NAME[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getUserID();
            case 1:
                return list.get(rowIndex).getUsername();
            case 2:
                return dbOps.getDepartmentName(list.get(rowIndex).getDepartmentID());
            case 3:
                return list.get(rowIndex).getDesignation();    
            case 4:
                return list.get(rowIndex).getEmail(); 
            case 5:
                return list.get(rowIndex).getMobileNumber();
            default:
                return "Error";
        }
    }    
}
