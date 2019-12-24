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
    * Pointers vary in speed or a different startIndex; when we have to swap

#### Example : Sort a Bit Array
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


