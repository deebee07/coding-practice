/*
https://leetcode.com/problems/kth-largest-element-in-an-array/
O(Nlogk)
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

        // keep k largest elements in the heap
        for (int n: nums) {
          heap.add(n);
        }
        
        int counter = 0;
        int currentLargest = Integer.MAX_VALUE;
        while (counter<k) {
            currentLargest = heap.poll();
            counter++;
        }
        

        // output
        return currentLargest;
  }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
        }

        // output
        return heap.poll();        
  }
}