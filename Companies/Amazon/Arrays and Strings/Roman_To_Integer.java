/*
https://leetcode.com/problems/roman-to-integer
Ⅰ（1）、Ⅴ（5）、Ⅹ（10）、Ⅼ（50）、Ⅽ（100）、Ⅾ（500）and Ⅿ（1000）
*/

class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int sum = 0;
        int prev = map.get(s.charAt(0)); // Previous would be the one at 0 place firstChar
        int next = 0;

        for (int i = 1; i < s.length(); i++) {
            next = map.get(s.charAt(i)); // start from second

            if (prev < next) {
                sum -= prev;
            } else {
                sum += prev;
            }

            //update prev because it is like sliding window
            prev = next;
        }

        sum += prev;//corner case when only one digit, we need to let sum = prev, so we add prev, not next
        return sum;
    }
}