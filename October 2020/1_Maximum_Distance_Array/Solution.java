/*
Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

Example 1:
Input: 
[[1,2,3],
 [4,5],
 [1,2,3]]
Output: 4
Explanation: 
One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
Note:
Each given array will have at least 1 number. There will be at least two non-empty arrays.
The total number of the integers in all the m arrays will be in the range of [2, 10000].
The integers in the m arrays will be in the range of [-10000, 10000].




*/

public class Solution {
    public int maxDistance(int[][] list) {
        int res = 0;
        int min_val = list[0][0];
        int max_val = list[0][list[0].length - 1];
        
        
        for (int i = 1; i < list.length; i++) {
            res = Math.max(res, Math.max(Math.abs(list[i][list[i].length - 1] - min_val), Math.abs(max_val - list[i][0])));
            min_val = Math.min(min_val, list[i][0]);
            max_val = Math.max(max_val, list[i][list[i].length - 1]);
        }
        return res;
    }
}

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        
        List<Integer> firstList = arrays.get(0);
        
        Integer min_value = firstList.get(0);
        Integer max_value = firstList.get(firstList.size()-1);
        int result = 0;
        
        
        for (int i=1; i<arrays.size();i++) {
            List<Integer> currentList = arrays.get(i);
            result = Math.max(result, Math.max((max_value - currentList.get(0)), (currentList.get(currentList.size()-1)-min_value)));
                              
            min_value = Math.min(min_value, currentList.get(0));
            max_value = Math.max(max_value, currentList.get(currentList.size()-1));
        }
        return result;
    }
}



