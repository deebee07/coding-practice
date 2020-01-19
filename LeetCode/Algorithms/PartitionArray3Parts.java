/*
https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
*/
class Solution {

    public boolean canThreePartsEqualSum(int[] A) {
        int totalSum = 0;
        //Total Sum
        for(int i = 0; i<A.length; i++) {
            totalSum += A[i];
        }

        int partialSum = totalSum/3;
        int temp = partialSum; //partialSum should happen 3 times
        int count = 0;
        
        for(int i = 0; i<A.length; i++) {
            temp-=A[i];
            if(temp==0) {
                temp = partialSum; // reinitialize partialSum as temp for next count
                count++;
            }
        }
        return count==3;
    }

}
