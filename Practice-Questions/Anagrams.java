/** 
 * 
 * https://leetcode.com/problems/valid-anagram/submissions/
*/

public class Anagrams {
        public boolean isAnagram(final String s, final String t) {

            if (s == null || t == null)
                return false;
            if (s.equals("") && t.equals(""))
                return true;

            final char[] sCharArray = s.toCharArray();
            final char[] tCharArray = t.toCharArray();

            Arrays.sort(sCharArray);
            Arrays.sort(tCharArray);
            final String sSorted = new String(sCharArray);
            final String tSorted = new String(tCharArray);
            
            return sSorted.equals(tSorted);
            
        }
}