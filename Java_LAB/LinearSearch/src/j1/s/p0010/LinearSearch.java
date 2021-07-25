package j1.s.p0010;

import java.util.Scanner;

public class LinearSearch {
    Scanner sc = new Scanner(System.in);
    public int linearSearch (int a[], int search) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == search) {
                return i;
            }
        }
        return -1;
    }
    
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
    
    public int getInt_Search(String mgs, String error){
        int result;
        do{
            try{
                System.out.print(mgs);
                result = Integer.parseInt(sc.next());
                return result;
            }catch(NumberFormatException e){
                System.err.println(error);
            }
        }while(true);
    }
}
