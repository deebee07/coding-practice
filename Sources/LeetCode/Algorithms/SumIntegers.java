/*
https://leetcode.com/problems/sum-of-two-integers/
https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
*/

class Solution {
    
    /*
    Sum of two bits can be obtained by performing XOR (^) of the two bits. 
    
    Carry bit can be obtained by performing AND (&) of two bits.
    */
    public int getSum(int a, int b) {
        
        if (a == 0) { // if 1 number is made 0; means sum is done return other number as it holds totalSum
            return b;
        } else { // else recursively call with sumOfNumber XOR a^b handle carry leftShift (a&b)<<1 (& gets carry leftShift)
            return getSum((a&b)<<1,a^b);
        }
        
    }
}