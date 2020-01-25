/* 
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Array is Sorted so just 2 pointers are good enough
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int Arrlength = numbers.length;
        int i = 0;
        int j = numbers.length -1;
        while(i<j){
            if (numbers[i]+numbers[j]==target){
                return new int[]{i+1, j+1};
            } else if (numbers[i]+numbers[j]>target){
                j--;
            } else {
                i++;
            }
        }
        throw new IllegalArgumentException("No such found with target equal");
    }
}