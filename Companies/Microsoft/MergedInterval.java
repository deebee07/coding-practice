/*
https://leetcode.com/problems/merge-intervals

The idea is to sort the intervals by their starting points. Then, we take the first interval and compare its end with the next intervals starts. As long as they overlap, we update the end to be the max end of the overlapping intervals. Once we find a non overlapping interval, we can add the previous "extended" interval and start over.
Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).
I used a lambda comparator (Java 8) and a for-each loop to try to keep the code clean and simple.
*/

// class Solution {
// 	public int[][] merge(int[][] intervals) {
// 		if (intervals.length <= 1)
// 			return intervals;

// 		// Sort by ascending starting point
// 		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

// 		List<int[]> result = new ArrayList<>();
// 		int[] newInterval = intervals[0];
// 		result.add(newInterval);
// 		for (int[] interval : intervals) {
// 			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
// 				newInterval[1] = Math.max(newInterval[1], interval[1]);
// 			else {                             // Disjoint intervals, add the new interval to the list
// 				newInterval = interval;
// 				result.add(newInterval);
// 			}
// 		}

// 		return result.toArray(new int[result.size()][]);
// 	}
// }


class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0][0];
        
        Arrays.sort(intervals, ((x, y) -> x[0] - y[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0])
                current[1] = Math.max(current[1], intervals[i][1]);
            else {
                merged.add(current);
                current = intervals[i];                
            }
        }
        merged.add(current);
        return merged.toArray(new int[0][0]);
    }
}