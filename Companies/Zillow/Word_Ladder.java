/*
https://leetcode.com/problems/word-ladder/
https://leetcode.com/problems/word-ladder/discuss/494002/Two-Java-BFS-Solutions
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        
        if(!dict.contains(endWord)) {
            return 0;
        } // if destination not present return length 0

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1)); // put beginWord as pair with 1st startNode in graph
        
        Set<String> set = new HashSet();
        set.add(beginWord);
        
        while(!queue.isEmpty()) {
            Pair<String, Integer> currentWordData = queue.poll();
            String currentWord = currentWordData.getKey();
            
            int freq = currentWordData.getValue();
            
            for(int i = 0; i < currentWord.length(); i++) {
                char[] arr = currentWord.toCharArray(); // traverse word
                
                for(char a = 'a'; a <= 'z'; a++) {
                    arr[i] = a; 
                    
                    String newWord = new String(arr);
                    
                    if(dict.contains(newWord) && newWord.equals(endWord)) {
                        return freq + 1;
                    }
                    
                    // keep on adding to crawled words if in dictionary new word and not in set of crawled
                    if(dict.contains(newWord) && !set.contains(newWord)) {
                        queue.add(new Pair(newWord, freq + 1));
                        set.add(newWord);
                    }
                }
            }
        }
        return 0;
    }
}