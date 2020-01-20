/*
Generate Parentheses
https://leetcode.com/problems/generate-parentheses/
*/


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        helper(result, "", 0, 0, n); //bottom up approach n = 0; openCount=0 closeCount=0
        return result;
    }

    public void helper(List<String> result, String currentString, int open, int close, int max){

        if (currentString.length() == max * 2) { // if string.length() is max*2 (n*2 brackets for result)
            result.add(currentString);
            return;
        }
        
        /*
        for everyOpen bracket you add: (open can be added up until max)
            add a respective closeBracket (close hasToBeAdded until close < open)
        
        */
        if (open < max)
            helper(result, currentString+"(", open+1, close, max);
        if (close < open)
            helper(result, currentString+")", open, close+1, max);
    }
}