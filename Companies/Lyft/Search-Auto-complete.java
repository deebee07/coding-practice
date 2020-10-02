/*
https://leetcode.com/problems/design-search-autocomplete-system/submissions/
*/
class Node {
  String sentence;
  int times;

  Node(String st, int t) {
    sentence = st;
    times = t;
  }
}

class Trie {
  int times;
  Trie[] branches = new Trie[27];
}

class AutocompleteSystem {
  private Trie root;
  private String cur_sent = "";

  public AutocompleteSystem(String[] sentences, int[] times) {
    root = new Trie();
    for (int i = 0; i < sentences.length; i++) {
      insert(root, sentences[i], times[i]);
    }
  }

  private int toInt(char c) {
    return c == ' ' ? 26 : c - 'a';
  }

  private void insert(Trie t, String s, int times) {
    for (int i = 0; i < s.length(); i++) {
      if (t.branches[toInt(s.charAt(i))] == null) {
        t.branches[toInt(s.charAt(i))] = new Trie();
      }
      t = t.branches[toInt(s.charAt(i))];
    }
    t.times += times;
  }

  private List<Node> lookup(Trie t, String s) {
    List<Node> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (t.branches[toInt(s.charAt(i))] == null) {
        return new ArrayList<>();
      }
      t = t.branches[toInt(s.charAt(i))];
    }
    traverse(s, t, list);
    return list;
  }

  private void traverse(String s, Trie t, List<Node> list) {
    if (t.times > 0) list.add(new Node(s, t.times));
    for (char i = 'a'; i <= 'z'; i++) {
      if (t.branches[i - 'a'] != null) {
        traverse(s + i, t.branches[i - 'a'], list);
      }
    }
    if (t.branches[26] != null) {
      traverse(s + ' ', t.branches[26], list);
    }
  }

  public List<String> input(char c) {
    List<String> res = new ArrayList<>();
    if (c == '#') {
      insert(root, cur_sent, 1);
      cur_sent = "";
    } else {
      cur_sent += c;
      List<Node> list = lookup(root, cur_sent);
      Collections.sort(
          list,
          (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
      for (int i = 0; i < Math.min(3, list.size()); i++) res.add(list.get(i).sentence);
    }
    return res;
  }
}   