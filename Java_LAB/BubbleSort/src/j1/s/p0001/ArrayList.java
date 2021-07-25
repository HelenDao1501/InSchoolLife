package j1.s.p0001;

import java.util.Scanner;

public class ArrayList {
    Scanner sc=new Scanner(System.in);
    
    void Input(int list[], int n){
        for(int i = 0; i < n; i++){
            System.out.println("Input the element "+i+"/"+n);
            list[i]=sc.nextInt();
        }  
    }
    
    void Output(int list[], int n){
        for(int i = 0; i < n; i++){
            System.out.println(list[i]);
        }
    }
    
    void Sort(int list[], int n){
        int a;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(list[i] > list[j]){
                    a = list[i];
                    list[i] = list[j];
                    list[j] = a;
                }
            }
        }   
    }
}
