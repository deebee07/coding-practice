/*
Top K Frequent Words

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.

Complexity Analysis

Time Complexity: O(NlogN), where N is the length of words. We count the frequency of each word in O(N) time, then we sort the given words in O(NlogN) time.

Space Complexity: O(N), the space used to store our candidates.


*/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        //create a frequency map with each String how many times it comes
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word: words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0)+1);
        }
        
        List<String> uniqueWordList = new ArrayList<>(frequencyMap.keySet());
        
        
        Collections.sort(uniqueWordList, (word1, word2) -> frequencyMap.get(word1).equals(frequencyMap.get(word2)) ? word1.compareTo(word2): frequencyMap.get(word2)-frequencyMap.get(word1));
        
        
        return uniqueWordList.subList(0,k);
        
    }
}
