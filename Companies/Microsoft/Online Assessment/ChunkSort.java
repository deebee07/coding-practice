//https://leetcode.com/discuss/interview-question/524146/Microsoft-or-OA-2020-or-Max-Chunks-to-Sort-Array
//https://leetcode.com/problems/max-chunks-to-make-sorted/

//https://leetcode.com/discuss/interview-question/524146/Microsoft-or-OA-2020-or-Max-Chunks-to-Sort-Array


// A valid chunk is an index range [a, b] which the values in the range are also from [a, b].
// So we can find the range end of each range by the max value inside this range.
// Here's the code:

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int end = -1;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > end) {
                end = arr[i];
            }
            if (i == end) {
                count++;
            }
        }
        return count;
        }
    }

