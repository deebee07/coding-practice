// DP solution. This is obviously not as good as the binary search solutions; but it did pass OJ.

// dp[s,j] is the solution for splitting subarray n[j]...n[L-1] into s parts.

// dp[s+1,i] = min{ max(dp[s,j], n[i]+...+n[j-1]) }, i+1 <= j <= L-s

// This solution does not take advantage of the fact that the numbers are non-negative (except to break the inner loop early). That is a loss. (On the other hand, it can be used for the problem containing arbitrary numbers)

public int splitArray(int[] nums, int m)
{
    int L = nums.length;
    int[] S = new int[L+1];
    S[0]=0;
    for(int i=0; i<L; i++)
        S[i+1] = S[i]+nums[i];

    int[] dp = new int[L];
    for(int i=0; i<L; i++)
        dp[i] = S[L]-S[i];

    for(int s=1; s<m; s++)
    {
        for(int i=0; i<L-s; i++)
        {
            dp[i]=Integer.MAX_VALUE;
            for(int j=i+1; j<=L-s; j++)
            {
                int t = Math.max(dp[j], S[j]-S[i]);
                if(t<=dp[i])
                    dp[i]=t;
                else
                    break;
            }
        }
    }

    return dp[0];
}



/*
https://leetcode.com/problems/split-array-largest-sum/
Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. 

Write an algorithm to minimize the largest sum among these m subarrays.
*/

class Solution {
    /* Max value can be from the range max(nums) <= v <= sum(nums)
    Therefore applying binary search from low = max(nums) and high = sum(nums). */
    
     public int splitArray(int[] nums, int m) {
                    
            long l = 0, r = 0;
            for(int n : nums)
            {
                l = Math.max(l, n); //biggestNum
                r += n; // sumOfAll
            }
            
            while(l < r) {
                long mid = l + (r-l)/2, need = 1, curr = 0;
                for(int n : nums) {
                   /* Greedy choice to make sure if curr + n (contiguous subset) is  more than max == mid then we need to divide it further otherwise keep adding to the contiguous set. 
                   */
                    if(curr + n > mid) // addNumber and increment need SUM IS GREATER THAN MID
                    {
                        need++;
                        curr = 0;
                    }
                    curr += n;
                }
                /* if need or divided sub arrays is less than required then we need to look into smaller values i.e. left side of the array.
                Even if need == m we have the possibility for minimizing it therefore keep looking in left size of an array unit we find minimum of maximum. */
                if(need <= m) r = mid; 
                
               else l = mid + 1; // vice-versa
            }
             
            return (int)r; // max value is on right side of an array. 
        }
    }


    // The answer is between maximum value of input array numbers and sum of those numbers.
    // Use binary search to approach the correct answer. We have l = max number of array; r = sum of all numbers in the array;Every time we do mid = (l + r) / 2;
    // Use greedy to narrow down left and right boundaries in binary search.
    // 3.1 Cut the array from left.
    // 3.2 Try our best to make sure that the sum of numbers between each two cuts (inclusive) is large enough but still less than mid.
    // 3.3 We'll end up with two results: either we can divide the array into more than m subarrays or we cannot.
    // If we can, it means that the mid value we pick is too small because we've already tried our best to make sure each part holds as many non-negative numbers as we can but we still have numbers left. So, it is impossible to cut the array into m parts and make sure each parts is no larger than mid. We should increase m. This leads to l = mid + 1;
    // If we can't, it is either we successfully divide the array into m parts and the sum of each part is less than mid, or we used up all numbers before we reach m. Both of them mean that we should lower mid because we need to find the minimum one. This leads to r = mid - 1;
    public class Solution {
        public int splitArray(int[] nums, int m) {
            int max = 0; long sum = 0;
            for (int num : nums) {
                max = Math.max(num, max);
                sum += num;
            }
            if (m == 1) return (int)sum;
            //binary search
            long l = max; long r = sum;
            while (l <= r) {
                long mid = (l + r)/ 2;
                if (valid(mid, nums, m)) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return (int)l;
        }
        public boolean valid(long target, int[] nums, int m) {
            int count = 1;
            long total = 0;
            for(int num : nums) {
                total += num;
                if (total > target) {
                    total = num;
                    count++;
                    if (count > m) {
                        return false;
                    }
                }
            }
            return true;
        }
    }