/*
https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/445/
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

___: current interval(i); _ _ _: newInterval

1) i.end < newInterval.start，then we can safely add i to result;
	newInterval still needs to be compared with latter intervals

	|________|
			       |_ _ _ _ _|
			
2) i.start > newInterval.end，then we can safely add both to result，
	and mark newInterval as null
	
			       |________|
	|_ _ _ _ _|
			
3) There is overlap between i and newInterval. We can merge i into newInterval, 
then use the updated newInterval to compare with latter intervals.

	
	|________|
		|_ _ _ _ _|
			
		|________|
	|_ _ _ _ _|
*/


public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new ArrayList<Interval>();
    for (Interval i : intervals) {
        if (newInterval == null || i.end < newInterval.start)
            result.add(i);
        else if (i.start > newInterval.end) {
            result.add(newInterval);
            result.add(i);
            newInterval = null;
        } else {
            newInterval.start = Math.min(newInterval.start, i.start);
            newInterval.end = Math.max(newInterval.end, i.end);
        }
    }
    if (newInterval != null)
        result.add(newInterval);
    return result;
}

class Solution {
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
         List<int[]> result = new ArrayList<>();
        
         for(int[] i : intervals){
             if(newInterval == null || i[1] < newInterval[0]){
                 result.add(i);
             }else if(i[0] > newInterval[1]){
                // be carefult the sequence here
                 result.add(newInterval);
                 result.add(i);
                 newInterval = null;
             }else{
                 
                 newInterval[0] = Math.min(newInterval[0], i[0]);//get min
                 newInterval[1] = Math.max(newInterval[1], i[1]);//get max
             }
         }
        
        if(newInterval != null)
            result.add(newInterval);
        
        return result.toArray(new int[result.size()][]);
    }
}

import java.util.*;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class InsertInterval {

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    if (intervals == null || intervals.isEmpty())
      return Arrays.asList(newInterval);

    List<Interval> mergedIntervals = new ArrayList<>();

    int i = 0;
    // skip (and add to output) all intervals that come before the 'newInterval'
    while (i < intervals.size() && intervals.get(i).end < newInterval.start)
      mergedIntervals.add(intervals.get(i++));

    // merge all intervals that overlap with 'newInterval'
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
      newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
      newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
      i++;
    }

    // insert the newInterval
    mergedIntervals.add(newInterval);

    // add all the remaining intervals to the output
    while (i < intervals.size())
      mergedIntervals.add(intervals.get(i++));

    return mergedIntervals;
  }

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(2, 3));
    input.add(new Interval(5, 7));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}
