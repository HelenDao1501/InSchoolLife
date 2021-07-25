package j1.s.p0004;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        Scanner sc = new Scanner(System.in);
        String checkYN;
        do {
            int n = qs.sizeOfArray();
            int [] a = new int[n];
            //import ulti.random de lay cac so nn sao cho = sl phan tu nhap
            Random rd = new Random();
            for (int i = 0; i < n; i++) {
                System.out.print("Number " + (i+1) + " : ");
                a[i] = rd.nextInt(50);
                System.out.println(a[i]);
            }
            System.out.print("Unsorted array: ");
            qs.print(a);
            System.out.println();
            qs.quickSort(a, 0, a.length - 1);
            System.out.print("Sorted array: ");
            qs.print(a);
            System.out.println("");
            do {
                System.out.print("Do you wanna continue this program? Y/N: ");
                checkYN = sc.next();
                if (!checkYN.equalsIgnoreCase("Y") && !checkYN.equalsIgnoreCase("N")) {
                    System.err.println("Enter Y/N!");
                }              
            } while (!checkYN.equalsIgnoreCase("Y") && !checkYN.equalsIgnoreCase("N"));
        } while (checkYN.equalsIgnoreCase("Y"));
    }
}
