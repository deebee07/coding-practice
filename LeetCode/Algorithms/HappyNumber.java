/*
https://leetcode.com/problems/happy-number/

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/
class Solution {
    
    public int getSum(int n) {
        int sum = 0;
        while (n>0) {
            int digit = n%10;
            sum += digit * digit;
            n = n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        ArrayList<Integer> listOfNum = new ArrayList<Integer>();
        int newNum = n;

        while (!listOfNum.contains(newNum)) {
            listOfNum.add(newNum); // 19 in list
            int getSum = getSum(newNum); // 82 
            newNum = getSum;
            if (newNum == 1) return true;
        }
        return false;
        
    }
    

}
