/*
https://leetcode.com/problems/word-break/
https://leetcode.com/problems/word-break/discuss/43908/4-different-ways-to-solve-this-with-detailed-explanation

*/

class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
    
        if (s == null || s.isEmpty()) {
            return false;
        }

        int len = s.length();
        boolean[] dp = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                // NOTE: we are going to update dp only for below two scenarios, so avoided
                // making unecessary computation until this condition is met
                if (j == 0 || dp[j - 1]) {
                    String sub = s.substring(j, i + 1);
                    if (wordDict.contains(sub)) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[len - 1];
}
}

class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxWord = getMax(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i ++) {
            int start = Math.max(1, i - maxWord);
            for (int j = start; j <= i; j++) {
                if (dp[j - 1] && wordDict.contains(s.substring(j - 1, i))) {
                    dp[i] = true; 
                    break;
                }
            }
        }
        return dp[len];
    }
    
    private int getMax(List<String> wordDict) {
        int max = 0;
        for (String str : wordDict) {
            max = Math.max(max, str.length());
        }
        return max;
    }
    }


    public class Solution {
        public boolean wordBreak(String s, List<String> dict) {
            // DFS
            List<Integer> set = new LinkedList<Integer>();
            return dfs(s, 0, dict, set);
        }
        
        private boolean dfs(String s, int index, List<String> dict, List<Integer> set){
            // base case
            if(index == s.length()) return true;
            // check memory
            if(set.contains(index)) return false;
            // recursion
            for(int i = index+1;i <= s.length();i++){
                String t = s.substring(index, i);
                if(dict.contains(t))
                    if(dfs(s, i, dict, set))
                        return true;
                    else
                        set.add(i);
            }
            set.add(index);
            return false;
        }
    }