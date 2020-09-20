// https://leetcode.com/problems/meeting-rooms-ii/
class Solution {
public int minMeetingRooms(int[][] intervals) {
	if (intervals.length == 0) {
		return 0;
	}
	// sort the input array on the basis of meeting start time
	Arrays.sort(intervals, new Comparator<int[]>() {
		@Override
		public int compare(int[] a, int[] b) {
			return a[0] - b[0];
		}
	});

	// initialize a minHeap on the basis of ending time of meetings
	PriorityQueue<int[]> minQueueOfIntervals = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] a, int[] b) {
			return a[1] - b[1];
		}
	});
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
