import java.util.*;

public class SequentialDigits {

    /*
    https://leetcode.com/problems/sequential-digits/
    
    An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
    
    Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
    
    Input: low = 100, high = 300
    Output: [123,234]
    
    Input: low = 1000, high = 13000
    Output: [1234,2345,3456,4567,5678,6789,12345]
    
    */ 
     public static void main(String []args){
        System.out.println(sequentialDigits(100, 300));
     }
     
    public static List<Integer> sequentialDigits (int low, int high) {
        // All sequenial digits would be made via substring of string
        String sampleNumber = "123456789";
        int n = 10;
        List<Integer> nums = new ArrayList<Integer>();
        
        
        int lowLength = String.valueOf(low).length();   // length of lowRange (countOfLowBits)
        int highLength = String.valueOf(high).length(); // length of highRange (countOfHighBits)
        
        for (int countOfDigit = lowLength; countOfDigit <=highLength; countOfDigit ++) { 
            // loop for all lengths in range (Digits in Number count)
        
            for (int start=0; start<n-countOfDigit; start++) {
                // iterate over sampleNumber with above countOfDigit
                
                int num = Integer.parseInt(sampleNumber.substring(start, start + countOfDigit));
                if (num >= low && num <= high) nums.add(num);
            }
            
            
        }
        
        return nums;
        
    }
     
     
}
