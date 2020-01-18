/*
https://leetcode.com/problems/reverse-vowels-of-a-string
*/

class Solution {
    public String reverseVowels(String s) {
        
        if (s == null) throw new IllegalArgumentException("null string passed");
        if (s.length() == 0) return "";
        
        char[] chars = s.toCharArray();
        List<Character> vowels = new ArrayList<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        int left = 0;
        int right = chars.length-1;
        
        while(left<right) {
            if (vowels.contains(chars[left])) {
            } else {
                left++;
                continue;
            }
            
            if (vowels.contains(chars[right])) { 
            } else {
                right--;
                continue;
            }
            
            if (vowels.contains(chars[right]) && vowels.contains(chars[left])) {
                
                //swap when left and right both are at vowel
                char temp = chars[right];
                chars[right] = chars[left];
                chars[left] = temp;
                left++;
                right--;
            }
        }
        

        return new String(chars);
        
    }
}