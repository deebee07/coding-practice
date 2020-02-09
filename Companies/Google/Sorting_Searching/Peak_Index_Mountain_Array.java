/*
https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/3084/
*/
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int i = 0;
        while (A[i] < A[i+1]) i++;
        return i;
    }
}