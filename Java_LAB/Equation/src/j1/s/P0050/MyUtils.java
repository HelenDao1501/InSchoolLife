package j1.s.P0050;

import java.util.Scanner;

public class MyUtils {
    Scanner sc = new Scanner(System.in);
    int choiceUsing(int limitOfChoice, String msg, String warning, String error){
        int number;
        do{            
            try{
                System.out.print(msg);
                number = Integer.parseInt(sc.nextLine());
                if(number < 0 || number > limitOfChoice){
                    System.out.println(warning);
                }else
                    return number;
            }catch(NumberFormatException e){
                System.out.println(error);
            }
        }while(true);
    }
    
    float getNumber(String msg, String error){
        float number;
        do{            
            try{
                System.out.print(msg);
                number = Float.parseFloat(sc.nextLine());
                return number;
            }catch(NumberFormatException e) {
                System.out.println(error);
            }
        }while(true);
    }
    
    int checkFlag(int flag){
        if(flag == 0)
            System.out.print("There is no number");
        return 0;
    }
}
