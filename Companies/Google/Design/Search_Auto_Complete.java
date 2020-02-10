class Node {
    String sentence;
    int times;
  
    Node(String st, int t) {
      sentence = st;
      times = t;
    }
  }
  
  class AutocompleteSystem {
    private HashMap<String, Integer> map = new HashMap<>();
    private String cur_sent = "";
  
    public AutocompleteSystem(String[] sentences, int[] times) {
      for (int i = 0; i < sentences.length; i++) map.put(sentences[i], times[i]);
    }
  
    public List<String> input(char c) {
      List<String> res = new ArrayList<>();
      if (c == '#') {
        map.put(cur_sent, map.getOrDefault(cur_sent, 0) + 1);
        cur_sent = "";
      } else {
        List<Node> list = new ArrayList<>();
        cur_sent += c;
        for (String key : map.keySet())
          if (key.indexOf(cur_sent) == 0) {
            list.add(new Node(key, map.get(key)));
          }
        Collections.sort(
            list,
            (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
        for (int i = 0; i < Math.min(3, list.size()); i++) res.add(list.get(i).sentence);
      }
      return res;
    }
  }
  
  /**
   * Your AutocompleteSystem object will be instantiated and called as such:
   * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
   * List<String> param_1 = obj.input(c);
   */


   