// Brute-Force Slow
// class Solution {
//     public int threeSumSmaller(int[] nums, int target) {
        
//         Arrays.sort(nums);
//         int countTriplets = 0;
//         for (int i=0;i+2<nums.length;i++) {
//             int j = i+1;
//             int k = nums.length-1;
//             while(j<k){
//                 int sum = nums[i]+nums[j]+nums[k];
//                 if (sum < target){
//                     countTriplets++;
//                 }
//             }
//         }
//         return countTriplets;
        
//     }
// }
// https://leetcode.com/problems/3sum-smaller
public class Solution {
    int count;
    
    public int threeSumSmaller(int[] nums, int target) {
        count = 0;
        Arrays.sort(nums);
        int len = nums.length;
    
        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return count;
    }
}