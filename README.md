# Brute-force approach: 
* Less logical errors
* Sacrifice Time complexity for simplicity
# Broad and Specific Techniques:
* Efficient solutions
  ## Broad techniques:
  1. Divide and Conquer
  2. Dynamic Programming
  ## Specific techniques:
  1. Multiple pointers
  2. Frequency Count

### Multiple pointers:
* Arrays, Lists and Strings [force us at times to use more than 1 pointer]
    * Pointers **vary in speed** or a **different startIndex**; when we have to swap

#### Example : Sort a Bit Array

#####  Time: O(N) Space: O(1)
```
import java.util.*;

public class SortBitArray{

     public static void main(String []args){
        System.out.println(Arrays.toString(sortBitArray(new int[]{0,1,0,1,0,1,1,1,1,1,0,0})));
     }
     
     
     public static int[] sortBitArray(int[] unsortedArray) {
        int left = 0; // onePointer runnning from left (start)
        int right = unsortedArray.length -1; // otherPointer runnning from right (end)
        
        while (left < right) {
            if (unsortedArray[left]==0) left ++; // if element @ left 0 moveForward
            if (unsortedArray[right]==1) right --; // if element @ right 1 moveBackward
            if (left<right) { // Basecondition: swapElement @ left and right
                int temp = unsortedArray[left];
                unsortedArray[left] = unsortedArray[right];
                unsortedArray[right] = temp;
            }
        }
        return unsortedArray;
     }
}
```

#### Example : Sorted Two Sum

#####  Time: O(N) Space: O(1)

```
import java.util.*;

/* Given a sorted array of integers and a target value, determine if there exists two integers in the array that sum up to the target value.

Approach 1: Brute Force
The brute force approach would be, to try out every single possible pair combination and see if the sum matches the target. This would lead to a O(N^2) time complexity because the number of pairs is proportional to N^2.

Approach 2: Frequency Hash
We could also try to create a hashmap for lookup time to find a match. But this would lead to a 
O(N) amount of auxiliary space.

Approach 3: 
left and right pointers we can find the sum
O(N) time and O(1) auxiliary space.
*/

public class SortedTwoSum {

     public static void main(String []args){
        int[] sortedArray = new int[] {45,56,67,90,100,123,345,567,890,999,1011,1502,1809};
        int target = 90;
        System.out.println(sortedTwoSum(sortedArray, target));
        target = 912; //sumOf index: [6,7]
        System.out.println(sortedTwoSum(sortedArray, target));
     }
     
     
     public static boolean sortedTwoSum(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;
         
        while (left < right) {
            if ((sortedArray[left] + sortedArray[right]) == target) {
                return true;
            } else if ((sortedArray[left] + sortedArray[right]) > target) { 
                right --;
            } else if ((sortedArray[left]+sortedArray[right])<target) {
                left++;
            }
        }
        return false;
     }
}
```
#### Example : Merge Two Sorted Arrays

#####  Time:O(N+M) Space: O(N+M)
```
import java.util.*;

/*
Merge Two Sorted Arrays
Given two sorted arrays of integers, combine the values into one sorted array

Input: [1,3,5], [2,4,6,8,10]

Output: [1,2,3,4,5,6,8,10]

See if you can solve this in O(N+M) time and O(N+M) auxiliary space.
*/

public class MergeTwoSortedArray {

     public static void main(String []args){
        int[] sortedArray_1 = new int[] {45,56,67,90,100,123,345,567,890,999,1011,1502,1809};
        int[] sortedArray_2 = new int[] {1,2,3,4,5,6,7,8,9,1000,20000,300000};
        System.out.println(Arrays.toString(mergeTwoSortedArray(sortedArray_1, sortedArray_2)));

     }
     
     
     public static int[] mergeTwoSortedArray(int[] sortedArray_1, int[] sortedArray_2) {
        
        int index_1 = 0, index_2 = 0, index = 0;
        int finalArrayLength = sortedArray_1.length + sortedArray_2.length;
        int resultArray[] = new int[finalArrayLength];
        
        // Run Loop untill all indexes of resultArray && we havent traversed through Array_1 or Array_2
        while (index<finalArrayLength && index_1<sortedArray_1.length && index_2<sortedArray_2.length) {
            
            // If Arr_1 has smaller number put it in resultArray
            // increment index of resultArray and that of Array_1
            if (sortedArray_1[index_1] < sortedArray_2[index_2]) {
                resultArray[index] = sortedArray_1[index_1];
                index_1++;
                index++;
                            
            // If Arr_2 has smaller number put it in resultArray
            // increment index of resultArray and that of Array_2
            } else if (sortedArray_2[index_2] < sortedArray_1[index_1]) {
                resultArray[index] = sortedArray_2[index_2];
                index_2++;
                index++;
            } else { 

            // If Arr_1 has same element in Arr_2 number put it in resultArray TWICE
            // increment index of resultArray and that of Array_1 and Array_2
                resultArray[index] = sortedArray_2[index_2];
                index++;
                resultArray[index] = sortedArray_1[index_1];
                index_1++;
                index_2++;
            }
        }
        
        
        // Put rest in resultArray; if we still have elements left in Arr1
        if (index_1<sortedArray_1.length) {
            while (index<finalArrayLength) {
                resultArray[index] = sortedArray_1[index_1];
                index_1++;
                index++;
            }
        }
        // Put rest in resultArray; if we still have elements left in Arr2
        if (index_2<sortedArray_2.length) {
            while (index<finalArrayLength) {
                resultArray[index] = sortedArray_2[index_2];
                index_2++;
                index++;
            }
        }
        
        return resultArray;
     }
}
```

### Frequency Counting:
* Requires tracking, counting, or looking up values quickly.
* Solution involves a collection of some sort (i.e., array, hashtable, or string).
* Problem will involve **matching**, **counting**, or **confirming values** in the collection.

#### Example : Two Sum

#####  Time: O(N) Space: O(1)

```
/* 
Two Sum

Given an array of integers, and a target value determine if there are two integers that add to the sum.

Input: [4,2,6,5,7,9,10], 13
Output: true
*/

import java.util.*;

public class TwoSum {

    public static void main(String []args){
        System.out.println(getTwoSum(new int[]{4,2,6,5,7,9,10}, 13));
    }
    
    public static boolean getTwoSum(int[] searchArray, int target) {
        
        // key: Element and value: index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<searchArray.length; i++) {
            map.put(searchArray[i], i);
        }
        
        for(int i = 0; i<searchArray.length; i++) {
            int complement = target-searchArray[i];
            if (map.containsKey(complement) && map.get(complement)!=i) {
                return true;
            }
        }
        return false;
    }
}
```

#### Example : Sort a Bit Array

#####  Time: O(N) Space: O(1)

```
/* 
Sort a Bit Array
Solve this in O(N) time and O(1) auxiliary space.

Try to solve this using a frequency count rather than using multiple pointers, or using a comparison sort function.

Input :  [0, 1, 1, 0, 1, 1, 1, 0]
Output : [0, 0, 0, 1, 1, 1, 1, 1]
*/ 
import java.util.*;

public class SortBitArray {

    public static void main(String []args){
        System.out.println(Arrays.toString(sortBitArray(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0, 1, 1, 0, 1, 1, 1, 0})));
    }
    
    public static int[] sortBitArray(int[] sortArray) {
        
        // key: Element and value: frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<sortArray.length; i++) {
            map.put(sortArray[i], map.getOrDefault(sortArray[i], 0) + 1 );
        }
        
        int count0s = map.get(0); // Get frequency of 0s rest are 1s
        System.out.println(count0s);
        
        for (int i = 0; i<sortArray.length; i++) {
            
            if (i<count0s) {
                sortArray[i] = 0;
            } else {
                sortArray[i] = 1;
            }
        
        }
        
        
        return sortArray;
    }
}

```
