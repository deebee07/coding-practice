
/*
https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2973/
*/
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
    
        paragraph = paragraph.replaceAll("[\\!\\?',;\\.]", " ").toLowerCase();
    
        Map<String, Integer> counts = new HashMap<>();
        Set<String> bans = Arrays.stream(banned).collect(Collectors.toSet());
    
        Arrays.stream(paragraph.split("\\s+"))
            .filter(s -> !bans.contains(s))
            .forEach(s -> counts.put(s, counts.getOrDefault(s, 0) + 1));
    
        return counts.keySet().stream()
            .reduce((a,b) -> counts.get(a) > counts.get(b) ? a : b)
            .get();
    }
    }