/*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 

Constraints:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.
https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2974/
*/

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] log1Array = log1.split(" ", 2);
            String[] log2Array = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(log1Array[1].charAt(0));
            boolean isDigit2 = Character.isDigit(log2Array[1].charAt(0));
            
            if(isDigit1 && isDigit2) { // both are digits
                return 0;
            } else if(isDigit1 && !isDigit2) { // string2 in front of digit1
                return 1;
            } else if(!isDigit1 && isDigit2) { // string1 in front of digit2
                return -1;
            }
            // else both are strings
            int compare = log1Array[1].compareTo(log2Array[1]);
            
            // if string1 == string2, return identifier comparator
            return compare == 0 ? log1Array[0].compareTo(log2Array[0]) : compare;
        });
        return logs;
    }
}