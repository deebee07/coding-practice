
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
        
        Map<Integer, Integer> mapOfCount = new HashMap<Integer, Integer>();
        
        /*
        iterate over arrayElements:
            if it containsKey getValue and increment by 1 
            else then just put 1 in for the key
        iterate over keySet of map:
            if key.get has value < 1 return Num
            
        */
        for (int i=0; i < nums.length; i++ ) {
            if (mapOfCount.containsKey(nums[i])) {
                mapOfCount.put(nums[i], mapOfCount.get(nums[i])+1);
            } else {
                mapOfCount.put(nums[i], 1);
            }
        }
        
        for (Integer iNum: mapOfCount.keySet()) {
            if (mapOfCount.get(iNum) == 1)
            {
                return iNum;
            }
        }
        throw new AssertionError("  ");
    }
}