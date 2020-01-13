/*
https://leetcode.com/problems/two-sum-less-than-k
*/


class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int length = A.length;
        Arrays.sort(A);
        int closestLessSum = Integer.MAX_VALUE;
        int sum = Integer.MIN_VALUE;
        int i = 0;
        int j = A.length - 1;

        while (i<j) {
            int S = A[i]+A[j];
            if (S>=K) {
                j--;
            } else { // K is greater than Sum
                int currentDiff = K-S;
                if (currentDiff<closestLessSum){
                    closestLessSum=currentDiff;
                    sum = S;
                }
                i++;
            }
            
        }
        if (sum ==Integer.MIN_VALUE){
            return -1;
        } else {
            return sum;
        }
        
    }
}