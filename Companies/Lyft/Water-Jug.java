/*
https://leetcode.com/problems/water-and-jug-problem/submissions/

*/

class Solution {
    /*https://en.wikipedia.org/wiki/Greatest_common_divisor#:~:text=In%20mathematics%2C%20the%20greatest%20common,8%20and%2012%20is%204.
     GCD - Greatest Common Divisor
     
     Find the greatest common divisor and check if gcd is a divisor of Z
     
     Edge cases: x+y need to be greater than or equal to Z otherwise z litters of waters cannot be contained on one or both x and y
     If x == y and x == z water is measurable (in case it's all 0 or GCD is x or y themselves)
    */
    //Time complexity O(log(y)-1)
    //Space complexity O(1)
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y < z)
            return false;
        else 
            return (x == y && x == z) || z % gcd(x,y) == 0;
    }
    
    private int gcd(int x, int y) {       
        while(y > 0) {
            int tmp = y;
            y = x%y;
            x = tmp;
        }
        
        return x;
    }
}