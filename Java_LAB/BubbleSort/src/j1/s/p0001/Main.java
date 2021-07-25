package j1.s.p0001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("Input number of elements:");
        n= sc.nextInt();
        int []a = new int[n];
        System.out.println("There're "+ n +" elements!");
        ArrayList obj= new ArrayList();
        obj.Input(a, n);
        System.out.println("Array before sorting:");
        obj.Output(a, n);
        System.out.println(" ");
        obj.Sort(a, n);
        System.out.println("Array after sorting:");
        obj.Output(a, n);
    }
    
}
