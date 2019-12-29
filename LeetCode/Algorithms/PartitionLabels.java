/* 
    https://leetcode.com/problems/partition-labels/
    
    A string S of lowercase letters is given. We want to partition this string into as many parts as       possible so that each letter appears in at most one part, and return a list of integers                 representing the size of these parts.
    
    
    Input: S = "ababcbacadefegdehijhklij"
    Output: [9,7,8]
    Explanation:
    The partition is "ababcbaca", "defegde", "hijhklij".
    This is a partition so that each letter appears in at most one part.
    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
    
    Note:

    S will have length in range [1, 500].
    S will consist of lowercase letters ('a' to 'z') only.
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastOccurenceofChars = new int[26]; 
        /* 
        a-z last occurence index of each character
        “A” is the decimal value 65
        “a” is decimal 97 // since its all lowercase we care about this +25 till "z"
        */
        for (int i = 0; i< S.length(); i++) {
            int charAtIndex = S.charAt(i) - 'a'; // index: charAt(i) - 'a' equivalent
            lastOccurenceofChars[charAtIndex] = i; // Get always the lastOccurence of character
        }
        
        int j = 0, anchor = 0;
        List<Integer> output = new ArrayList<>();
        
        for (int i = 0; i<S.length();i++) {
            int charAtIndex= S.charAt(i) - 'a'; // Get lastOccurence of character
            j = Math.max(j, lastOccurenceofChars[charAtIndex]);
            
            if (i == j) {
                output.add(i - anchor + 1);
                System.out.println(S.substring(anchor, j)); // These are the strings that give out partition labels
                anchor = i+1; // This is the index of nextPartition head as from anchor to current j
            }
        }
        return output;
        
        
    }
}
