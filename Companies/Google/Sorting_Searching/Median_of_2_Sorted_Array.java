class Solution {
    
    /*
    declare num_1_ind, num_2_ind = 0
    declare 
    
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