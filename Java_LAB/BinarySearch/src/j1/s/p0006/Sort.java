package j1.s.p0006;

public class Sort {
    public static void bubbleSort(int a[]) {
        int temp;
        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1 ; j < a.length ; j++) {
                if(a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    
    public static int binarySearch (int a[], int search, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (a[mid] == search) {
            return mid;
        } else if (a[mid] > search) {
            return binarySearch(a, search, left, mid - 1);
        } else
            return binarySearch(a, search, mid + 1, right);
    }
}
