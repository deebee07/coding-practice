/*
https://leetcode.com/problems/string-compression/
*/

class Solution {
    
    
    
    public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length) { // move from index 0 to chars.length-1
            
            char currentChar = chars[index]; // element
            int count = 0; // counter for element at index
            while(index < chars.length && chars[index] == currentChar){
                index++; //moveForward for same element
                count++; //getCount of indexElement
            }

            chars[indexAns] = currentChar;
            indexAns++;
            if(count != 1) {
                 for(char c : Integer.toString(count).toCharArray()){
                    chars[indexAns] = c;
                    indexAns++; 
                 }

            }

        }
        
        

        return indexAns;
    }

}