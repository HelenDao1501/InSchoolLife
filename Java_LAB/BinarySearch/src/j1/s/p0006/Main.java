package j1.s.p0006;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static MyUtils utl = new MyUtils();
    public static void main(String[] args) {
        String checkYN = null;
        do {
            int size;
            size = utl.getInt("Enter number of Array: ", "Greater than 0", "Please input number");
            int a[] = new int[size];
            //import random so => 50
            Random rd = new Random();
            System.out.println("Enter " + size + " positive number : ");
            for (int i = 0; i < size; i++) {
                System.out.print("Number [" + (i+1) + "] : " );
                a[i] = rd.nextInt(50);
                System.out.println(a[i]);
            }
            //Unsorted => Sorted
            System.out.println("Unsorted Array: " + Arrays.toString(a));
            Sort.bubbleSort(a);
            System.out.println("Sorted Array: " + Arrays.toString(a));

            //binarySearch
            do {
                do {
                    int searchNo;
                    searchNo = utl.getInt_Search("Enter search value: ", "Error", "Please input number!");
                    int foundedNo = Sort.binarySearch(a, searchNo, 0, size - 1);
                    if (foundedNo == -1) {
                        System.err.println("Not founded!");
                    } else
                        System.out.println(searchNo + " at index: " + foundedNo + " (With index position in array)");
                    
                    boolean check;
                    do {
                        check = true;
                        System.out.print("Do you wanna continue to search? Y/N: ");
                        sc = new Scanner(System.in);
                        checkYN = sc.nextLine();
                        if (!checkYN.equalsIgnoreCase("Y") && !checkYN.equalsIgnoreCase("N")) {
                            System.err.println("Enter Y/N!");
                            check = false;
                        }    
                    } while (check == false);                         
                } while (!checkYN.equalsIgnoreCase("Y") && !checkYN.equalsIgnoreCase("N"));
            } while (checkYN.equalsIgnoreCase("Y"));

            do {
                System.out.print("Do you wanna continue this program? Y/N: ");
                checkYN = sc.next();
                if (!checkYN.equalsIgnoreCase("Y") && !checkYN.equalsIgnoreCase("N")) {
                    System.err.println("Enter Y/N!");
                }              
            } while (!checkYN.equalsIgnoreCase("Y") && !checkYN.equalsIgnoreCase("N"));
        } while (checkYN.equalsIgnoreCase("Y"));     
        System.out.println("Good bye!");
    }   
}
