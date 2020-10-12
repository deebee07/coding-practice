/*
https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2975/
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

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
            /*
            if setting a new leftMax then add a solution between difference of leftMax and height[left]
            if setting a new rightMax then add a solution between difference of rightMax and height[right]
            */
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