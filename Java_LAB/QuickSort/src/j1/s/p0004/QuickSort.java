package j1.s.p0004;

import java.util.Scanner;

public class QuickSort {
    Scanner SC= new Scanner(System.in);
    
    //bat phai nhap so
    public int checkInputSize(){
        while(true){
            try{
                int result = Integer.parseInt(SC.nextLine().trim());
                if(result <= 0){
                    System.err.println("Greater than 0");
                }
                else{                    
                    return result;
                }
            }
            catch(NumberFormatException e){
                System.err.println("Please input number");
                System.out.print("Enter number again: ");
            }
        }
    }
    
    //ham dung de xd so luong phan tu
    public int sizeOfArray(){
        System.out.print("Input size of the array: ");
        int n = checkInputSize();
        return n;
    }
    
    //dung in ra list 
    public void print(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    
    //phan doan
    int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        //diem danh dau = 
        int pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
    
    void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }
    
}
