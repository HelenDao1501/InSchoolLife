package j1.s.p0006;

import java.util.Scanner;

public class MyUtils {
    Scanner sc = new Scanner(System.in);
    //dung trong check phai nhap dung kt int
    public int getInt(String mgs, String warning, String error){
        int result;
        do{
            try{
                System.out.print(mgs);
                result = Integer.parseInt(sc.next());
                if (result <= 0) {
                    System.err.println(warning);
                }
                else
                    return result;
            }catch(NumberFormatException e){
                System.err.println(error);
            }
        }while(true);
    }
    
    //bat nhap dung int de dung trong ham search
    public int getInt_Search(String mgs, String warning, String error){
        int result;
        do{
            try{
                System.out.print(mgs);
                result = Integer.parseInt(sc.next());
                if (result < 0) {
                    System.err.println(warning);
                }
                else
                    return result;
            }catch(NumberFormatException e){
                System.err.println(error);
            }
        }while(true);
    }
}
