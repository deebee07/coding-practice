/*
https://leetcode.com/problems/regular-expression-matching/
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
matching should cover the entire input string

Regular Expression Matching
*/

class Solution {
    /*
    Approach 1: Recursion
        If there were no Kleene stars (the * wildcard character for regular expressions), 
            the problem would be easier - we simply check from left to right if each character of the text matches the                  pattern
    
    When a star is present, we may need to check many different suffixes of the text and see if they match the rest of          the pattern. A recursive solution is a straightforward way to represent this relationship.
    
    If a star is present in the pattern, it will be in the second position \text{pattern[1]}pattern[1]. Then, we may ignore this part of the pattern, or delete a matching character in the text. If we have a match on the remaining strings after any of these operations, then the initial inputs matched.
    
    * will always be secondCharacter
        
    */
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty(); // if patternIsEmpty textShould also beEmpty

        /*
        To match firstChar of text and pattern:
            textNotEmpty
            &&
            pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'
            THIS HANDLES ONLY 1 LENGTH PATTERN BASE CASE
        */
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        
        /*
        if (patternLength >= 2 && pattern.charAt(1) == '*')
            return isMatch(text, pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern))
        */
        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}


