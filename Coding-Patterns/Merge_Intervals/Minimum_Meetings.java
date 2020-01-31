/*
https://leetcode.com/problems/meeting-rooms-ii/
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int[] interval : intervals) {
            if (pq.size() == 0 || pq.peek() > interval[0]) {
                pq.add(interval[1]);
            } else {
                pq.poll();
                pq.add(interval[1]);
            }
        }
        
        return pq.size();
    }
}