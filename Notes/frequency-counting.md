
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