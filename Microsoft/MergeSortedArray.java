class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        mergeFromBehind as element are empty in num1
        */
        
        int num1Ind = m-1;
        int num2Ind = n-1;
        
        for (int i=nums1.length-1; i>=0;i--) {
            
            if (num1Ind >=0 && num2Ind >=0) { // if we have 2 pointers to compare

                if (nums1[num1Ind]>nums2[num2Ind]) {

                    nums1[i] = nums1[num1Ind];
                    num1Ind--;
                } else {
                    nums1[i] = nums2[num2Ind];
                    num2Ind--;
                }
            } else { // if one is totally crawled just crawl one
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