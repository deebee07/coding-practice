/*

https://leetcode.com/problems/ugly-number/
Input: 6
Output: true
Explanation: 6 = 2 × 3

Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2

Input: 14
Output: false 
Explanation: 14 is not ugly since it includes another prime factor 7.
*/
class Solution {
    public boolean isUgly(int num) {
        
        ArrayList<Integer> uglyFactors = new ArrayList<Integer>();
        uglyFactors.add(2);
        uglyFactors.add(3);
        uglyFactors.add(5); // ArrayList stores uglyPrimeFactors that lead to uglyNumber
        
        for (Integer i: uglyFactors) { // Iterate overEach primeFactor
            
            while(num%i==0) { // Iterate forEach primeFactorNumber forItBeing divisible by num
                // If it is divisible
                num= num/i;
                if (num == 0) return false;
            }
            
        }
        
        if (num == 1) return true;
        return false;
    }
}
