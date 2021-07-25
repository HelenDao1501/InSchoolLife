package j1.s.P0073;

import java.util.ArrayList;
import java.util.Scanner;

public class MyUtils {
    Scanner sc = new Scanner(System.in);
    
    int choiceUsing(int limitOfChoice, String msg, String warning, String error){
        int number;
        do{            
            try{
                System.out.print(msg);
                number = Integer.parseInt(sc.nextLine());
                if(number < 1 || number > limitOfChoice){
                    System.out.println(warning);
                }else
                    return number;
            }catch(NumberFormatException e){
                System.out.println(error);
            }
        }while(true);
    }
    
    String getString(String msg, String warning){
        String result = "";
        do{
            System.out.println(msg);
            result = sc.nextLine();
            if(result.trim().isEmpty())
                System.out.println(warning);
        } while(result.trim().isEmpty());
        return result;
    }
    
    int getInt(String mgs, String warning, String error){
        int result;
        do{
            try{
                System.out.println(mgs);
                result = Integer.parseInt(sc.nextLine());
                if(result < 0)
                    System.out.println(warning);
                else
                    return result;
            }catch(NumberFormatException e){
                System.out.println(error);
            }
        }while(true);
    }
    
    public Expense getExpenseById(ArrayList<Expense> listd, int id) {
        for (Expense expense : listd) {
            if (expense.getId() == id) {
                return expense;
            }
        }
        return null;
    }
    
}
