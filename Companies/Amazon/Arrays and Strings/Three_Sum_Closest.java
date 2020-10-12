/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 

Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, closest = 0;
        
        for (int i=0; i+2<nums.length; i++) {
            int j = i+1;
            int k = nums.length -1;
            while (j<k){
                int sum = nums[k] + nums[i] + nums[j]; // findSum closest to target
                
                if (sum == target) { return target; }
                
                else if (sum > target) {
                    if (sum-target < diff) {
                        diff = sum-target;
                        closest = sum;
                    }
                    k--;
                } else {
                    if (target-sum < diff) {
                        diff = target-sum;
                        closest = sum;
                    }
                    j++;
                }
            }
        }
        return closest;
    }
}
