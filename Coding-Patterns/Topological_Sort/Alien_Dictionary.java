/*
https://leetcode.com/problems/alien-dictionary/
Easy 2 steps solution.

Build a graph from word list, by comparing two words at a time and adding unequal characters.
Example: If you have words wrt,wrf => we need to add t->f.
Once the graph is built, we can do topological sort using BFS. We'll maintain the visited node using the classic array based hashing of the character. We start our bfs from the point where, there are no incoming edges. The output of the topological sort will be our lexicographic order.*/
class Solution {    

    // indegree for characters
    int[] indegrees = new int[26];
    
    public String alienOrder(String[] words) {
        return topologicalSort(buildGraph(words),words);
    }
    
    public  Map<Character, List<Character>> buildGraph(String[] words){
        Map<Character, List<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i+1];
            int minLen = Math.min(cur.length(), next.length());
            for (int j = 0; j < minLen; j++) 
                if (cur.charAt(j) != next.charAt(j)) {
                    List<Character> list = graph.getOrDefault(cur.charAt(j), new ArrayList<>());
                    list.add(next.charAt(j));
                    graph.put(cur.charAt(j), list);
                    indegrees[next.charAt(j) - 'a']++;
                    break;
                }
        }
        return graph;
    }
    
    public String topologicalSort(Map<Character, List<Character>> graph, 
                                  String[] words){
        Set<Character> seen =scanAllChars(words);        
        StringBuilder res = new StringBuilder();        
        Queue<Character> todo = new LinkedList<>();
        for (char c : seen) 
            if (indegrees[c - 'a'] == 0)
                todo.offer(c);        
        
        while (!todo.isEmpty()) {
            char cur = todo.remove();
            res.append(cur);
            List<Character> nexts = graph.get(cur);
            if (nexts != null && !nexts.isEmpty()) 
                for (char next : nexts) {
                    indegrees[next - 'a']--;
                    if (indegrees[next - 'a'] == 0)
                        todo.offer(next);
                }            
        }
      return res.toString().length() != seen.size() ? "" :res.toString();
    }
    
    public Set<Character> scanAllChars(String[] words){
        Set<Character> seen = new HashSet<>();
        for (String word : words) 
            for (char c : word.toCharArray())
                seen.add(c);
        return seen;
    }
}