/*
Median of 2 Sorted Arrays
https://leetcode.com/problems/median-of-two-sorted-arrays/
https://leetcode.com/problems/median-of-two-sorted-arrays/

*/

class Solution {
    
    /*
    declare num_1_ind, num_2_ind = 0
    declare 
    O(m+n)
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     
        int num_1_ind = 0;
		int num_2_ind = 0;
        int totalNumbers = nums1.length + nums2.length;

		int midpos = (totalNumbers) / 2;

		double[] temp = new double[midpos + 1];
        int tempInd = 0;

		while (tempInd != midpos + 1) {

			if (num_1_ind == nums1.length && num_2_ind == nums2.length) {
				break;
			} else if (num_1_ind == nums1.length) {
				temp[tempInd] = nums2[num_2_ind];
				num_2_ind++;
                tempInd++;
			} else if (num_2_ind == nums2.length) {
				temp[tempInd] = nums1[num_1_ind];
				num_1_ind++;
                tempInd++;
			} else if (nums1[num_1_ind] > nums2[num_2_ind]) {
				temp[tempInd] = nums2[num_2_ind];
				num_2_ind++;
                tempInd++;
			} else if (nums1[num_1_ind] < nums2[num_2_ind]) {
				temp[tempInd] = nums1[num_1_ind];
				num_1_ind++;
                tempInd++;
			} else {
				temp[tempInd] = nums1[num_1_ind];
				num_1_ind++;
                tempInd++;
			}
		}

		if (totalNumbers%2 == 1) {
			return temp[tempInd-1]; // odd
		} else {
			return (temp[tempInd - 1] + temp[tempInd - 2]) / 2.0; // even
		}
    }
}


/*
This is my iterative solution using binary search. The main idea is to find the approximate location of the median and compare the elements around it to get the final result.

do binary search. suppose the shorter list is A with length n. the runtime is O(log(n)) which means no matter how large B array is, it only depends on the size of A. It makes sense because if A has only one element while B has 100 elements, the median must be one of A[0], B[49], and B[50] without check everything else. If A[0] <= B[49], B[49] is the answer; if B[49] < A[0] <= B[50], A[0] is the answer; else, B[50] is the answer.

After binary search, we get the approximate location of median. Now we just need to compare at most 4 elements to find the answer. This step is O(1).

the same solution can be applied to find kth element of 2 sorted arrays.

Here is the code:
https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2547/Share-my-iterative-solution-with-O(log(min(n-m)))
https://github.com/BruceZu/KeepTry/commit/c4ccbf84a1423c1fae1d1a113961cf77e3068b16

*/
    public double findMedianSortedArrays(int A[], int B[]) {
    int n = A.length;
    int m = B.length;
    // the following call is to make sure len(A) <= len(B).
    // yes, it calls itself, but at most once, shouldn't be
    // consider a recursive solution
    if (n > m)
        return findMedianSortedArrays(B, A);

    // now, do binary search
    int k = (n + m - 1) / 2;
    int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
    while (l < r) {
        int midA = (l + r) / 2;
        int midB = k - midA;
        if (A[midA] < B[midB])
            l = midA + 1;
        else
            r = midA;
    }
    
    // after binary search, we almost get the median because it must be between
    // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1] 

    // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
    // and there are some corner cases we need to take care of.
    int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
    if (((n + m) & 1) == 1)
        return (double) a;

    // if (n+m) is even, the median can be calculated by 
    //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
    // also, there are some corner cases to take care of.
    int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
    return (a + b) / 2.0;
}

/*
I'm lazy to type. But I found a very good pdf to explain my algorithm: http://ocw.alfaisal.edu/NR/rdonlyres/Electrical-Engineering-and-Computer-Science/6-046JFall-2005/30C68118-E436-4FE3-8C79-6BAFBB07D935/0/ps9sol.pdf

BTW: Thanks to xdxiaoxin. I've removed the check "midB > k".

*/