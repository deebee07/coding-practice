/*
https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/173/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

Put all elements in HashMap with key as element and value as index
    for each element iterate to find its complement
        complement is target - arra[i]
        if (map.containsKey(complement) && map.get(complement)!=i)
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