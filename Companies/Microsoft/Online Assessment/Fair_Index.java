//https://leetcode.com/discuss/interview-question/451422/


public static int fairIndex(int a[], int b[]){
    int sumA = 0;
    int sumB = 0;
    for(int i=0; i<a.length; i++){
        sumA+=a[i];
        sumB+=b[i];
    }
    int count = 0;
    int tempA = a[0];
    int tempB = b[0];
    for(int i = 1; i<a.length;i++){
        if(i!=1 && tempA == tempB && 2*tempA == sumA  && 2*tempB == sumB){
            count++;
        }
        tempA+=a[i];
        tempB+=b[i];
    }
    return count;
}

private static int getNumOfFairIndexes(int[] A, int[] B) {
	int res = 0, sumA = 0, sumB = 0;
	for(int i=0;i<A.length;i++) {
		sumA += A[i];
		sumB += B[i];
	}
	int tmpA = 0, tmpB = 0;
	for(int i=0;i<A.length-1;i++) {
		tmpA += A[i];
		tmpB += B[i];
		if(sumA == 2 * tmpA && sumB == 2 * tmpB && tmpA == tmpB)
			res++;
	}
	return res;
}