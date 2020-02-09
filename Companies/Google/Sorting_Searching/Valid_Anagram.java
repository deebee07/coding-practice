class Solution {
    public boolean isAnagram(String s, String t) {
        
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        String sSorted = String.valueOf(sCharArray);
        String tSorted = String.valueOf(tCharArray);
        
        return sSorted.equals(tSorted);
        
    }
}