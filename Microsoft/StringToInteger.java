/*
https://leetcode.com/problems/string-to-integer-atoi/
*/

class Solution {    
    /*     
Four cases:

    discards all leading whitespaces
sign of the number
overflow
invalid input
Is there any better solution? Thanks for pointing out!


*/

    public int myAtoi(String str) {

        int sign = 1, i = 0, curNumbr = 0;
        str = str.trim(); //trim whitespace in the string

        if (str.isEmpty()) return 0; // after removing whitespace if length is 0
        else if (str.charAt(i) == '-') { i++; sign = -1; } // i is 0 so you can get sign here now
        else if (str.charAt(i) == '+') { i++; }

        while (i < str.length() && Character.isDigit(str.charAt(i))) { // while loop iterate over until end of str
            int digit = str.charAt(i) - '0';
            
            /*
            curNumber > subtract from maxValue of 32 bit
            From my understanding, you are checking if you are going to overflow the int max before actually performing                 the operation. So you check if r is greater than Integer.MAX_VALUE minus d (since you'll add d if you                       perform the operation) divided by 10 (since you'll multiple by 10 if you perform the operation). Now if                 this condition is true, you have to apply the - sign if negative which is what the second part of this                     statement represents. Hope this helps!
            */
            if (curNumbr > (Integer.MAX_VALUE - digit) / 10) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            curNumbr = curNumbr * 10 + digit; // make the number by digit + r
            i++;
        }
        return curNumbr * sign;

    }
}