/*
https://leetcode.com/explore/interview/card/microsoft/47/sorting-and-searching/257/
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/

public class Solution
{
    public int removeDuplicates(int[] nums)
    {
        int dupes = 0;
        
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == nums[i - 1])
                dupes++;
            
            nums[i - dupes] = nums[i];
        }
        
        return nums.length - dupes;
    }
}





public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
}