/*
https://leetcode.com/problems/majority-element/
public int majorityElement(int[] nums) {
     Arrays.sort(nums);
     return nums[nums.length/2];
}

ArrayUtils.isNotEmpty(testArrayName)
*/


public int majorityElement(int[] num) {
    int count = 0; int major = num[0];
    for(int i:num) {
        if(count==0){ major=i; count++;	}
        else if(i==major) count++;
        else count--;
    }
    return major;
}


public class Solution {
    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
}

https://leetcode.com/problems/majority-element/discuss/352496/Java-accepted-code%3A-Sort-and-Boyer-Moore-Voting-Algorithm


public int majorityElement(int[] nums) {
    int candidate = nums[0];
    int count = 1;
    //2 4 4 1 3
    
    //Boyer Moore Vote Algorithm
    for(int i = 1; i < nums.length; i++){
        if(count == 0){
            candidate = nums[i];
            count = 1;
        }
        else{
            if(nums[i] == candidate){
                count++;
            }
            else{
                count--;
            }
        }
    }
    
    //
    count = 0;
    for(int i = 0; i < nums.length; i++){
        if(nums[i] == candidate){
            count++;
        }
    }
    if(count > nums.length/2){
        return candidate;
    }
    else{
        return -1;
    }
}
