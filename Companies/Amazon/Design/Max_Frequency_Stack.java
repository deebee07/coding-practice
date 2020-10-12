class FreqStack {

    Map<Integer, Integer> elements;  //freqOfKeyMap
    Map<Integer, Stack<Integer>> frequencyMap;
    int maxFrequency;

    public FreqStack() {
        elements = new HashMap<>();
        frequencyMap = new HashMap<>();
        maxFrequency = 0;
    }

    public void push(int x) {
        int frequency = elements.getOrDefault(x, 0) + 1;
        elements.put(x, frequency);
        if (!this.frequencyMap.containsKey(frequency)) {
            this.frequencyMap.put(frequency, new Stack<>());
        }
        this.frequencyMap.get(frequency).add(x);
        maxFrequency = Math.max(frequency, maxFrequency);
    }

    public int pop() {
        Integer pop = this.frequencyMap.get(maxFrequency).pop();
        int frequency = elements.getOrDefault(pop, 0) - 1;
        elements.put(pop, frequency);
        if (this.frequencyMap.get(maxFrequency).isEmpty()) {
            maxFrequency--;
        }
        return pop;
    }
}


class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq)
            maxfreq = f;

        group.computeIfAbsent(f, z-> new Stack()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }
}

/*
Time Complexity: O(1)O(1) for both push and pop operations.
*/

