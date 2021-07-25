package j1.s.p0010;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {  
        LinearSearch ls = new LinearSearch();
        String checkYN = null;
        do {
            int size = ls.getInt("Enter number of Array: ", "Greater than 0", " Please input number");
            int a[] = new int[size];
            Random rd = new Random();
            System.out.println("Enter " + size + " positive number : ");
            for (int i = 0; i < size; i++) {
                System.out.print("Number [" + (i+1) + "] : " );
                a[i] = rd.nextInt(50);
                System.out.println(a[i]);
            }
            
            System.out.println(Arrays.toString(a));
            
            //linearSearch            
            do {
                do {
                    int searchNo = ls.getInt_Search("Enter search value: ", "Please input number");
                    int foundedNo = ls.linearSearch(a, searchNo);
                    if (foundedNo == -1) {
                        System.err.println("Not founded!");
                    } else
                        System.out.println(searchNo + " at index: " + foundedNo + " (With real index position in array)");
                    boolean check;
                    do {
                        check = true;
                        System.out.print("Do you wanna continue to search? Y/N: ");
                        checkYN = sc.next();
                        if (!checkYN.equalsIgnoreCase("Y") && !checkYN.equalsIgnoreCase("N")) {
                            System.err.println("Enter Y/N!");
                            check = false;
                        }        
                    } while (check == false);                
                } while (!checkYN.equalsIgnoreCase("Y") && !checkYN.equalsIgnoreCase("N"));
            } while (checkYN.equalsIgnoreCase("Y"));
            
            do {
                System.out.print("Do you wanna continue? Y/N: ");
                checkYN = sc.next();
                if (!checkYN.equalsIgnoreCase("Y") && !checkYN.equalsIgnoreCase("N")) {
                    System.err.println("Enter Y/N!");
                }              
            } while (!checkYN.equalsIgnoreCase("Y") && !checkYN.equalsIgnoreCase("N"));
        } while (checkYN.equalsIgnoreCase("Y"));
        
    }
}
