/*
https://leetcode.com/problems/3sum/
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // sortArray
        
        
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result i-1 wont exist for 0
                continue;
            }
            int j = i + 1, k = nums.length - 1;  
            int target = -nums[i]; // a+b+c = 0 So: a+b=-c
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result j and overlap k if in end this is why j<k
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result j and overlap k if in end this is why j<k
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
    }