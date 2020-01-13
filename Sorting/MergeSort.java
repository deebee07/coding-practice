/*
Facebook Prep
Merge Sort

https://www.youtube.com/watch?v=KF2j-9iSf4Q

*/
import java.util.*;

public class MergeSort{

    public static void main(String []args){
        mergeSort(new int[]{45,67,89,1,2,3,4,23,67,54,32,21});
    }
    
    public static void mergeSort(int[] arrayToSort) {
        mergeSort(arrayToSort, new int[arrayToSort.length],0, arrayToSort.length-1);
    }
    
    public static void mergeSort(int[] arrayToSort, int[] outputArray, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        
        int middle = (leftIndex+rightIndex)/2;
        mergeSort(arrayToSort, outputArray, leftIndex, middle);
        mergeSort(arrayToSort, outputArray, middle+1, rightIndex);
        mergeHalves(arrayToSort, outputArray, leftIndex, rightIndex);
    }
    
    public static void mergeHalves (int[] arrayToSort, int[] outputArray, int leftIndex, int rightIndex) {
        
        int leftEnd = (leftIndex+rightIndex)/2;
        int rightStart = leftEnd + 1;
        int size = rightIndex - leftIndex + 1;
        
        int left = leftIndex;
        int index = leftIndex;
        int right = rightStart;
        
        while (left <= leftEnd && right <=rightIndex) {
            if (arrayToSort[left]<=arrayToSort[right]) {
                outputArray[index] = arrayToSort[left];
                left++;
            } else {
                outputArray[index] = arrayToSort[right];
                right++;
            }
            index++;
        }
        
        // Either left or right pointer goes to the end so only one line will work
        System.out.println(Arrays.toString(arrayToSort));
        System.out.println(Arrays.toString(outputArray));
        System.arraycopy(arrayToSort, left, outputArray, index, leftEnd-left+1);
        System.out.println(Arrays.toString(arrayToSort));
        System.arraycopy(arrayToSort, right, outputArray, index, rightIndex - right +1);
        System.arraycopy(outputArray, leftIndex, outputArray, leftIndex, size);
    }
     
     
}
