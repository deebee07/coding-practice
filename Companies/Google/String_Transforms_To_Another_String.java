/*
https://leetcode.com/problems/string-transforms-into-another-string/
https://leetcode.com/problems/string-transforms-into-another-string/discuss/355382/JavaC%2B%2BPython-Need-One-Unused-Character
Explanation
    Scan s1 and s2 at the same time,
        record the transform mapping into a map/array.

    Same char should transform to the same char; Otherwise we can directly return false

To realise the transformation:

transformation of link link ,like a -> b -> c:
we do the transformation from end to begin, that is b->c then a->b

transformation of cycle, like a -> b -> c -> a:
in this case we need a tmp
c->tmp, b->c a->b and tmp->a
Same as the process of swap two variable.

In both case, there should at least one character that is unused,
to use it as the tmp for transformation.
So we need to return if the size of set of unused characters < 26.


Complexity
Time O(N) for scanning input
Space O(26) to record the mapping
running time can be improved if count available character during the scan.

Strings s1 and s2 are of equal length

To Transform them we need to make convertion so every character of map we put

*/

class Solution {
    public boolean canConvert(String s1, String s2) {

        if (s1.equals(s2)) return true;

        Map<Character, Character> dp = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            
            if (dp.getOrDefault(s1.charAt(i), s2.charAt(i)) != s2.charAt(i))
                return false;
            dp.put(s1.charAt(i), s2.charAt(i));
        }

        return new HashSet<Character>(dp.values()).size() < 26;
    }
}






