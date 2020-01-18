/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/submissions/
*/class Solution {
    public String reverseWords(String s) {
        if (s==null) throw new IllegalArgumentException("Illegal input");
        if (s.length()==0) return "";
        
        String[] words = s.split(" ");
        StringBuilder output = new StringBuilder("");
        for (String word: words) {
            output.append(reverseWord(word)+" ");
        }
        return output.toString().substring(0, output.length()-1);
    }
    
    public String reverseWord(String word) {
        char[] charsInS = word.toCharArray();
        int left = 0;
        int right = charsInS.length-1;
        while (left<right) {
            char temp = charsInS[left];
            charsInS[left] = charsInS[right];
            charsInS[right] = temp;
            left++;
            right--;
        }
        return new String(charsInS);
    }
}