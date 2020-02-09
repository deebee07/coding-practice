
/*
Loop through the array:
    each time remember the max and min value for the previous product.
    the most important thing is to update the max and min value: 
        we have to compare among max * A[i], min * A[i] as well as A[i],
        since this is product, 
        a negative * negative could be positive.
GREEDY APPROACH
*/
public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]); // local maxima
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]); // local minima
            result = Math.max(result, max); // global maxima

        }
        return result;
    }
}