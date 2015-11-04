/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gskproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chamod
 */
public class Validation {
    
    public static boolean isUserIDCorrect(String id){
        Pattern p=Pattern.compile("[0-9]+");
        Matcher m=p.matcher(id);
        return m.matches();
    }
    
    public static boolean isEmaiCorrect(String email){
        Pattern p=Pattern.compile("[a-z]+@[a-z]+\\.com");
        Matcher m=p.matcher(email);
        return m.matches();
    }
    
    public static boolean isMobileNumberCorrect(String num){
        
        Pattern p=Pattern.compile("[0-9]+");
        Matcher m=p.matcher(num);
        if(m.matches()){
            if(num.length()==10){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
