package j1.s.P0061;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manage mn = new Manage();
        Scanner sc = new Scanner(System.in);
        String checkYN;
        do {            
            Rectangle rectangle = mn.inputRectangle();
            Circle circle = mn.inputCircle();
            Triangle triangle = mn.inputTriangle();

            mn.display(triangle, rectangle, circle);
            do {
                System.out.print("Do you wanna continue this program? Y/N: ");
                checkYN = sc.next();
                if (!checkYN.equalsIgnoreCase("Y") && !checkYN.equalsIgnoreCase("N")) {
                    System.err.println("Enter Y/N!");
                }              
            } while (!checkYN.equalsIgnoreCase("Y") && !checkYN.equalsIgnoreCase("N"));
        } while (checkYN.equalsIgnoreCase("Y"));
        System.out.println("Bye !");
    }
}
