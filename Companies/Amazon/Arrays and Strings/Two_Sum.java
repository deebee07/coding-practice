/*
https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/508/
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // key as Element: value as Index
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        
        for (int i=0; i<nums.length;i++) {
            map.put(nums[i], i);
        }
        
        for (int i=0; i<nums.length;i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i,map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }