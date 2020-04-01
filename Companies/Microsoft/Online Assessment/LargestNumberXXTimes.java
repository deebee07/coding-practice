//Largest number X which occurs X times
//https://leetcode.com/discuss/interview-question/525977/Microsoft-or-OA-2020-or-Largest-number-X-which-occurs-X-times


private static int findTheMax(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>(); 
    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int max = 0;
    for (int key : map.keySet()) {
        if (key == map.get(key)) {
            max = Math.max(max, key);
        }
    }
    return max;
}
