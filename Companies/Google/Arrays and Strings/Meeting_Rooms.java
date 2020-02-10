
/*
https://leetcode.com/problems/meeting-rooms-ii/

sort intervals based on startTime (index: 0)
declare priorityQueue:
    if (pq.size()==0 || peek()> interval[0])
        add interval[1]
    else
        pq.poll()
        add pq.add(interval[1])
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int[] interval : intervals) {
            if (pq.size() == 0 || pq.peek() > interval[0]) { // add a new node when peek() > interval[0]
                pq.add(interval[1]);
            } else {
                pq.poll();
                pq.add(interval[1]);
            }
        }
        
        return pq.size();
    }
}