/*
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3049/
https://leetcode.com/problems/3sum/

sort(array)
iterate i from 0 to i+2<arrLength;i++
    if i>0 && arr[i] == arr[i-1] continue;
    int left = i+1;
    int right = nums.length-1;
    int target = -1 * nums[i];

    while (left<right) {

        if (nums[left]+ nums[right]==target) {
            result.add(Arrays.asList(nums[left],nums[right],nums[i]));
            left++;
            right--;
            while (left < right && nums[left] == nums[left - 1]) left++;
            while (left < right && nums[right] == nums[right + 1]) right--;  
        } else if(nums[left]+nums[right]>target) {
            right--;
        } else {
            left++;
        }

    }
    
*/



class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for (int i=0; i+2<nums.length;i++){
            
            if (i>0 && nums[i]==nums[i-1]) {
                continue; //skipSameResult
            }
            int left = i+1; 
            int right = nums.length - 1;
            int target = -1 * nums[i];
            
            while(left<right) {
                if (nums[left]+nums[right]==target){
                    result.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;  
                    while (left < right && nums[right] == nums[right + 1]) right--;  
                } else if (nums[left]+nums[right]>target) {
                    right--;
                } else {
                    left++;
                }
            
            }
            
        }
        return result;
    }
    }