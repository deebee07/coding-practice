/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

class Solution {
    public boolean isHappy(int n) {
        List<Integer> numbers = new ArrayList<Integer>();
        while(true) {
             if (numbers.contains(n)) {
                return false;
            } else {
                numbers.add(n);
                if (n == 1) return true;
                n = getNextNum(n);
            }
        }
    }
    
    public int getNextNum(int n) {
        int sum = 0;
        while(n>0){
            int digit = n %10;
            sum += digit*digit;
            n = n/10;
        }
        return sum;
    }
}