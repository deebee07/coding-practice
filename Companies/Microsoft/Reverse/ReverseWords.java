/*
https://leetcode.com/problems/reverse-words-in-a-string
*/
class Solution {


    public String reverseWords(String s){
        StringBuilder result = new StringBuilder("");
        String[] words = s.split("\\s+"); // ADD FOR TAB SPACE HERE

        for (int i=words.length-1; i>=0;i--){
            result.append(words[i]+ " ");
        }

        return result.toString().trim();
    }
}