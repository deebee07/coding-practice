/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // sort the input array on the basis of meeting start time
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
    
        // initialize a minHeap on the basis of ending time of meetings
        PriorityQueue<int[]> minQueueOfIntervals = new PriorityQueue<int[]>((a, b)->a[1] - b[1]);
        
        minQueueOfIntervals.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = minQueueOfIntervals.poll();
            
            if (intervals[i][0] >= currentInterval[1]) { // if meeting on the top of heap(i.e. with min ending time)ends before
                currentInterval[1] = intervals[i][1];    // the start of next meeting. Then simply update the ending time.Else add in heap.
            } else {
                minQueueOfIntervals.offer(intervals[i]);
            }
            minQueueOfIntervals.offer(currentInterval);
        }
        return minQueueOfIntervals.size();
    }
    }
    