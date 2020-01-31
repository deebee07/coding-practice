/* https://leetcode.com/problems/jump-game/solution/
    This is the inefficient solution where we try every single jump pattern 
    that takes us from the first position to the last.
    We start from the first position and jump to every index that is reachable. 
    We repeat the process until last index is reached. When stuck, backtrack.
*/



public class Solution {
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
}


/*
Complexity Analysis

Time complexity : O(n). We are doing a single pass through the nums array, hence nn steps, where nn is the length of array nums.

Space complexity : O(1). We are not using any extra memory.

Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index 
 (currPosition + nums[currPosition] >= leftmostGoodIndex)
*/

public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}


/*
Complexity Analysis

Time complexity : O(n). We are doing a single pass through the nums array, hence nn steps, where nn is the length of array nums.

Space complexity : O(1). We are not using any extra memory.

Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index 
 (currPosition + nums[currPosition] >= leftmostGoodIndex)
*/
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int max = nums[0]; // maximum number of jumps from 0
        for(int i = 0; i <= max; i++) {
            if(max >= nums.length - 1) return true;
            max = Math.max(max, i + nums[i]);
        }
        return false;
    }
}