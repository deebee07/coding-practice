/*
https://leetcode.com/problems/peak-index-in-a-mountain-array/
*/
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi)/ 2;
            if (A[mid] < A[mid + 1]) { lo = mid + 1; } // peak index is after mid.
            else{ hi = mid; } // peak index <= mid.
        }
        return lo; // found peak index.
    }
}

public int peakIndexInMountainArray(int[] A) {
    for (int i = 1; i < A.length; ++i) {
        if (A[i - 1] < A[i] && A[i] > A[i + 1]) { return i; }
    }
    return -1; // no peak.
}

public int peakIndexInMountainArray(int[] A) {
    int i = 1;
    while (A[i] < A[i + 1]) i++;
    return i;
}

public int peakIndexInMountainArray(int[] A) {
    if(A == null || A.length == 0) return -1;
    int low = 0, high = A.length - 1;
    while(low < high){
        int mid = low + (high - low)/2;
        if(A[mid] < A[mid + 1]){
            low = mid + 1;
        }else if(A[mid] > A[mid + 1]){
            high = mid;
        }else{
            return -1;
        }
    }
    if(low == 0 || low == A.length - 1) return -1;
    return low;
}