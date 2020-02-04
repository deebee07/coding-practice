/*
https://leetcode.com/problems/split-array-largest-sum/
*/

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
           
            for(int n : nums) {
                l = Math.max(l, n);
                r += n;
            }
            
            while(l < r)
            {
                long mid = (l + r)/2, need = 1, curr = 0;
                
                for(int n : nums)
                {
                   /* Greedy choice to make sure if curr + n (contiguous subset) is  more than max == mid then we need to divide it further otherwise keep adding to the contiguous set. 
                   */
                    if(curr + n > mid)
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


/*
https://leetcode.com/problems/split-array-largest-sum/
Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. 

Write an algorithm to minimize the largest sum among these m subarrays.
*/

class Solution {
	public int splitArray(int[] nums, int m) {
		int left = nums[0];
		int right = left;
		for (int i = 1; i < nums.length; i++) {
			right += nums[i];
			left = Math.max(left, nums[i]);
		}
		while (left < right) {
			int mid = left + (right - left)/2;
			if (existCut(nums, m, mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
	private boolean existCut(int[] nums, int m, int target) {
		int segment = 1, index = 1, sum = nums[0];
		while (segment <= m && index < nums.length ) {
			if (sum + nums[index] > target) {
				segment++;
				sum = nums[index];
			} else {
				sum += nums[index];
			}
			index++;
		}
		if (segment > m) {
			return false;
		} else {
			return true;
		}
	}
	}