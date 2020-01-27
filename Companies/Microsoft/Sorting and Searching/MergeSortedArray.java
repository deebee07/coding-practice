/*
https://leetcode.com/explore/interview/card/microsoft/47/sorting-and-searching/258/
https://leetcode.com/problems/merge-sorted-array/
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      // two get pointers for nums1 and nums2
      int p1 = m - 1;
      int p2 = n - 1;
      // set pointer for nums1
      int p = m + n - 1;
  
      // while there are still elements to compare
      while ((p1 >= 0) && (p2 >= 0))
        // compare two elements from nums1 and nums2 
        // and add the largest one in nums1 
        nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
  
      // add missing elements from nums2
      System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
  }


  class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        mergeFromBehind as element are empty in num1
        */
        
        int num1Ind = m-1;
        int num2Ind = n-1;
        
        for (int i=nums1.length-1; i>=0;i--) {
            
            if (num1Ind >=0 && num2Ind >=0) { // if either of the array is fully parsed

                if (nums1[num1Ind]>nums2[num2Ind]) {

                    nums1[i] = nums1[num1Ind];
                    num1Ind--;
                } else {
                    nums1[i] = nums2[num2Ind];
                    num2Ind--;
                }
            } else {
                if (num1Ind>=0) {
                    nums1[i] = nums1[num1Ind];
                    num1Ind--;
                }
                if (num2Ind >=0) {
                    nums1[i] = nums2[num2Ind];
                    num2Ind--;
                }
            }   
        }
        
    }
    
}