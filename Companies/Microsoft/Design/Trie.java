/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 * https://leetcode.com/problems/implement-trie-prefix-tree
 * https://leetcode.com/problems/implement-trie-prefix-tree/discuss/58986/Concise-O(1)-JAVA-solution-based-on-HashMap
 * 
 */
class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        isEnd = true;
        children = new TrieNode[26];
    }
}

public class Trie {
private TrieNode root;

public Trie() {
    root = new TrieNode();
}

public void insert(String word) {
    TrieNode current = root;

    for(int i=0, L=word.length(); i<L; i++) {
        int id = word.charAt(i) - 'a';
        if(current.children[id]==null) {
            current.children[id] = new TrieNode();
            current.children[id].isEnd = false;
        }
        current = current.children[id];
    }
    current.isEnd = true;

}

public boolean search(String word) {
    return search(word, 1);
}
public boolean startsWith(String prefix) {
    return search(prefix, 2);
}
private boolean search(String str, int type) {
    TrieNode current = root;
    int i=-1, L=str.length();
    while(++i<L) {
        int id = str.charAt(i) - 'a';
        if((current=current.children[id]) == null) return false;
    }
    return type==1 ? current.isEnd : true;
}
}



// OTHER SOLUTION

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }    
    public void insert(String word) {
        TrieNode node  = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children == null) 
                node.children = new HashMap<Character, TrieNode>();
            if (!node.children.containsKey(ch)) 
                node.children.put(ch, new TrieNode(ch));            
            node = node.children.get(ch);
        }
        node.isLeaf = true;
    }    
    public boolean search(String word) {
        TrieNode node  = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children == null || !node.children.containsKey(ch))
                return false;
            node = node.children.get(ch);
        }
        return node.isLeaf;
    }     
    public boolean startsWith(String prefix) {
        TrieNode node  = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children == null || !node.children.containsKey(ch))
                return false;
            node = node.children.get(ch);
        }
        return true;
    }
}
class TrieNode {
    public Map<Character, TrieNode>children = null;
    public boolean isLeaf = false;
    public char val;
    public TrieNode() {
        
    }
    public TrieNode(char val) {
        this.val = val;
    }
}

// HASHMAP SOLUTION

/*
Time Complexity
insert(): O(n)
search(): O(n)
startsWith(): O(n)

Space Complexity
insert(): O(n)
search(): O(1)
startsWith(): O(1)
*/
class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    public boolean isEnd = false; // "public" for simplicity

    public void putChildIfAbsent(char ch) {
        children.putIfAbsent(ch, new TrieNode());
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr.putChildIfAbsent(ch);
            curr = curr.getChild(ch);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr = curr.getChild(ch);
            if (curr == null) {
                return false;
            }
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            curr = curr.getChild(ch);
            if (curr == null) {
                return false;
            }
        }
        return true;
    }
}
