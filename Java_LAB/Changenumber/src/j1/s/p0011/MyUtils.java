package j1.s.p0011;

import java.util.Scanner;

public class MyUtils {
    Scanner sc = new Scanner(System.in);
    //dặt điều kiện
    private final String BINARY_VALID = "[0-1]*";
    private final String DECIMAL_VALID = "(-)?[0-9]*";
    private final String HEXADECIMAL_VALID = "[0-9A-F]*";
    
    //bat nhap so theo dinh dang
    public int choiceUsing(int limitOfChoice, String msg, String warning, String error){
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
    
    public String checkInputBinary() {
        System.out.print("Enter number binary: ");
        String result;
        while (true) {
            result = sc.nextLine().trim();
            if (result.matches(BINARY_VALID)) {
                return result;
            }
            System.err.println("Must be enter 0 or 1");
            System.out.print("Enter again: ");
        }
    }

    public String checkInputDecimal() {
        System.out.print("Enter number decimal: ");
        String result;
        while (true) {
            result = sc.nextLine().trim();
            if (result.matches(DECIMAL_VALID)) {
                return result;
            }
            System.err.println("Must be enter 0-9");
            System.out.print("Enter again: ");
        }
    }

    public String checkInputHexaDecimal() {
        System.out.print("Enter number hexadecimal: ");
        String result;
        while (true) {
            result = sc.nextLine().trim();
            if (result.matches(HEXADECIMAL_VALID)) {
                return result;
            }
            System.err.println("Must be enter 0-9 A-F");
            System.out.print("Enter again: ");
        }
    }
    
    
    
}
