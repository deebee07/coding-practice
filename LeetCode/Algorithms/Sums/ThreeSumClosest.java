/*
https://leetcode.com/problems/3sum-closest
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
