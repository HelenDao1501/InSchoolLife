/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0055;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class MyUtils {
    Scanner sc = new Scanner(System.in);
    
    int choiceUsing(int limitOfChoice, String msg, String warning, String error){
        int number;
        do{            
            try{
                System.out.print(msg);
                number = Integer.parseInt(sc.nextLine());
                if(number < 1 || number > limitOfChoice){
                    System.err.println(warning);
                }else
                    return number;
            }catch(NumberFormatException e){
                System.err.println(error);
            }
        }while(true);
    }
    
    String getString(String msg, String warning){
        String result = "";
        do{
            System.out.print(msg);
            result = sc.nextLine();
            if(result.trim().isEmpty())
                System.err.println(warning);
        } while(result.trim().isEmpty());
        return result;
    }
    
    //check xem co ton tai hay ko?
    public boolean checkCodeExist(ArrayList<Doctor> listd, String code) {
        for (Doctor doctor : listd) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }
    
    //tim doctor qua code de sua/ xoa
    public Doctor getDoctorByCode(ArrayList<Doctor> listd, String code) {
        for (Doctor doctor : listd) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }
    
    //bat nhap dung dinh dang
    int getInt(String mgs, String warning, String error){
        int result;
        do{
            try{
                System.out.print(mgs);
                result = Integer.parseInt(sc.nextLine());
                if(result < 0)
                    System.err.println(warning);
                else
                    return result;
            }catch(NumberFormatException e){
                System.err.println(error);
            }
        }while(true);
    }
}
