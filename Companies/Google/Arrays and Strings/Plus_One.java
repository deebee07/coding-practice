/*
https://leetcode.com/explore/interview/card/google/59/array-and-strings/339/
https://leetcode.com/problems/plus-one/submissions/
*/

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
				// simulate a "carry" by continuing the loop
            }
        }

        // Code reaches here for inputs of all 9s such as [9, 9, 9]
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}