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


