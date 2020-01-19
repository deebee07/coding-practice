/* 
https://leetcode.com/problems/trapping-rain-water/
*/
class Solution {
    public int trap(int[] height) {
        if(height==null || height.length ==0) return 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int levelWaterCount = 0;
        
        while(left<right) {
            if(height[left]>leftMax) leftMax = height[left];
            
            if(height[right]>rightMax) rightMax = height[right];
            
            if(leftMax<rightMax) {
                levelWaterCount+=Math.max(0, leftMax-height[left]); //height of water can be maximum of minimum
                left++;
            } else {
                levelWaterCount+=Math.max(0, rightMax-height[right]);
                right--;
            }
            
        }
        return levelWaterCount;
    }
}

// int trap(vector<int>& height)
// {
//     int left = 0, right = height.size() - 1;
//     int ans = 0;
//     int left_max = 0, right_max = 0;
//     while (left < right) {
//         // a taller bar exists on left pointer's right side
//         if (height[left] < height[right]) {
//             height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
//             ++left;
//         }
//         // a taller bar exists on right pointer's left side
//         else {
//             height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
//             --right;
//         }
//     }
//     return ans;
// }