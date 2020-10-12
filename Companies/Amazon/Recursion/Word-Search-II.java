/*
https://leetcode.com/explore/interview/card/amazon/84/recursion/2990/
*/
class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    TrieNode root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            dfs (board, i, j, root, res);
        }
    }
    return res;
}

public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
    char c = board[i][j];
    if (c == '#' || p.next[c - 'a'] == null) return;
    p = p.next[c - 'a'];
    if (p.word != null) {   // found one
        res.add(p.word);
        p.word = null;     // de-duplicate
    }

    board[i][j] = '#';
    if (i > 0) dfs(board, i - 1, j ,p, res); 
    if (j > 0) dfs(board, i, j - 1, p, res);
    if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
    if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
    board[i][j] = c;
}

public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String w : words) {
        TrieNode p = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (p.next[i] == null) p.next[i] = new TrieNode();
            p = p.next[i];
       }
       p.word = w;
    }
    return root;
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}
}


class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for(String word : words){
            if(exists(board, word)){
                ans.add(word);
            }
        }
      return ans;  
    }
    
    
    private boolean exists(char[][]board,String word){
        for(int i=0;i<board.length;i++){
            for(int j = 0; j < board[i].length ; j++){
                if(board[i][j] == word.charAt(0) && dfs(board,word,0,i,j)){
                    return true;
                } 
            }
        }
      return false;  
     }
    
    
   private boolean dfs(char[][]board,String word,int index,int i,int j){
       if(index == word.length()){
           return true;
       }
       
     if(i  < 0 || i >= board.length || j < 0 || j >= board[i].length || word.charAt(index) != board[i][j]){
         return false;
       }  
     char temp = board[i][j];
     board[i][j] = ' ';  
     boolean res = dfs(board,word,index+1,i+1,j)
                   ||dfs(board,word,index+1,i-1,j)
                   ||dfs(board,word,index+1,i,j+1)
                   ||dfs(board,word,index+1,i,j-1);
       board[i][j] = temp;
     return res;  
   }
    
    
}