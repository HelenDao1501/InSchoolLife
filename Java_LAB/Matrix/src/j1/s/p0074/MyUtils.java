package j1.s.p0074;

import java.util.Scanner;

public class MyUtils {
    Scanner sc = new Scanner(System.in);

    Integer getInt(String msg, String warning, String error) {
        int result = 0;
        while (true) {
            try {
                System.out.println(msg);
                result = Integer.parseInt(sc.nextLine());
                if (result <= 0) {
                    System.out.println(warning);
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }

    }
    
    int getElmt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Number format only!");
            }
        }

    }
}

