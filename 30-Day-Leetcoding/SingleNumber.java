//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/
/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

*/

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }
        
        for(Integer key: frequencyMap.keySet()) {
            if (frequencyMap.get(key)==1) return key;
        }
        return -1; // throw new Exception or just return -1
    }
}


/*
Bit Manipulation

Complexity Analysis

Time complexity : O(n).
We only iterate through \text{nums}nums, so the time complexity is the number of elements in nums.

Space complexity : O(1).


class Solution {
  public int singleNumber(int[] nums) {
    int a = 0;
    for (int i : nums) {
      a ^= i;
    }
    return a;
  }
}


*/