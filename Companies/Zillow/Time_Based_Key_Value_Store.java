/*
https://leetcode.com/problems/time-based-key-value-store/
TimeMap has a Map M 
    with key as key(String) 
        and 
    value as (timeStamp, value)TreeMap<Integer, String>
setFunction would take key, value, timeStamp
    if keyNotPresent
        addKey and put a new TreeMap -> M.put(key, new TreeMap());
    M.get(key).put(timestamp, value);
*/

class TimeMap {
    Map<String, TreeMap<Integer, String>> M;

    public TimeMap() {
        this.M = new HashMap<String, TreeMap<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) {
        if (!M.containsKey(key))
            M.put(key, new TreeMap());

        M.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!M.containsKey(key)) return "";

        TreeMap<Integer, String> tree = M.get(key);
        Integer t = tree.floorKey(timestamp);
        return t != null ? tree.get(t) : "";
    }
}