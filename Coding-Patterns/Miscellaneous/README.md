 ## Miscellaneous

 Kth Smallest Number


 Solution 1: Brute-Force
    Time complexity: O(N^2)
    Space complexity: O(1)

 Solution 2: Brute-Force with Sorting
    Time complexity: O(NlogN)
    Space complexity: O(N)

 Solution 3: Max-Heap
    Time complexity: O(NlogK) 
    Space complexity: O(K) // K smallest numbers in the heap
 ```
 import java.util.*;

class KthSmallestNumber {

  public static int findKthSmallestNumber(int[] nums, int k) {

    // use PriorityQueue of type Integer make it a maxHeap (n1)
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
    // put first k numbers in the max heap
    for (int i = 0; i < k; i++)
      maxHeap.add(nums[i]);

    // go through the remaining numbers of the array, if the number from the array is smaller than the
    // top (biggest) number of the heap, remove the top number from heap and add the number from array
    for (int i = k; i < nums.length; i++) {
      if (nums[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.add(nums[i]);
      }
    }

    // the root of the heap has the Kth smallest number
    return maxHeap.peek();
  }

  public static void main(String[] args) {
    int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
    System.out.println("Kth smallest number is: " + result);

    // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
    result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
    System.out.println("Kth smallest number is: " + result);

    result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
    System.out.println("Kth smallest number is: " + result);  }
}
```


Solution 4: Median of Medians

Smarter Quick Sort
    Time complexity: O(N) 
    Space complexity: O(N)
https://en.wikipedia.org/wiki/Median_of_medians


