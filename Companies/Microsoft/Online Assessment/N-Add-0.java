//N Unique Integers Sum up to Zero
//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/discuss/474793/Java-or-Runtime-faster-than-100.00-Memory-Usage-less-than-100.00


class Solution {
    public int[] sumZero(int n) {
        
        
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            ans[i]  = (i*2)-n+1;
        }
        return ans;
    }
}


class Solution {
    public int[] sumZero(int n) {
        int[] list= new int[n];
        int index=0;
       // find the mid number of n
       int mid =n/2;
        // loop the mid number from negative to positive
        for (int i=(-1*mid);i<=mid;i++) {
        // if even number then dont add 0 number else add 0
        if(i==0 && n%2==0){
             continue; 
        }
         list[index++]=i; 
        }
        
        return list;
    }
}