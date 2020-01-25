/*
https://leetcode.com/problems/spiral-matrix
*/
class Solution {
	public int[][] generateMatrix(int n) {
		int rStart=0,rEnd=n-1;
		int cStart=0,cEnd=n-1;

		int[][] matrix=new int[n][n];
		int counter=1;
		while(rStart<=rEnd && cStart<=cEnd){

			for(int c=cStart;c<=cEnd;c++) matrix[rStart][c]=counter++;
			for(int r=rStart+1;r<=rEnd;r++) matrix[r][cEnd]=counter++;

			// if(rStart<rEnd && cStart<cEnd){
				for(int c=cEnd-1;c>cStart;c--) matrix[rEnd][c]=counter++;
				for(int r=rEnd;r>rStart;r--) matrix[r][cStart]=counter++;
			// }

			rStart++;
			rEnd--;
			cStart++;
			cEnd--;

		}

		return matrix;
	}
}