package TDD;

public class Searching {
	public static boolean binSearch(int sortedArr[], int searchValue) {
		if(sortedArr == null) 
			return false;
		else
			return binarySearch(sortedArr, searchValue, 0, sortedArr.length - 1);
	}
	public  static boolean binarySearch(int sortedArr[], int searchValue, int begin, int end) {
		if (end >= begin) { 
            int mid = begin + (end - begin) / 2; 
            if (sortedArr[mid] == searchValue) 
                return true; 
            if (sortedArr[mid] > searchValue) 
                return binarySearch(sortedArr, searchValue, begin, mid - 1); 
            return binarySearch(sortedArr, searchValue , mid + 1,  end); 
        } 
        return false; 
	}
	
}
