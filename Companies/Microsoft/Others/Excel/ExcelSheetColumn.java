/*
https://leetcode.com/problems/excel-sheet-column-title/
*/

public class Solution {
    /* 
     This is simple conversion from base 10 to base 26. However, the new base (base 26) is one based, so our alphabet [1,26] which maps to A~Z. Using the mod operator gives numbers in range [0, 25]. That's why he used (n-1) so he's converting n from 1 based to 0 based. Hope this helps.
     */
     public String convertToTitle(int n) {
         String result = "";
         
         /*
         ASCII
         65 is A
         97 is a
         */
         while (n>0) {
             n--; //for 0
             int intVal = n%26;
             char asciiVal = (char) (intVal + 65);
             result = asciiVal + result;
             n = n/26;
         }
         return result;
     }
 }