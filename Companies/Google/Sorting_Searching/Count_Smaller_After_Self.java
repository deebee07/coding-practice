//https://leetcode.com/problems/count-of-smaller-numbers-after-self/submissions/
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int n = nums.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        treeMap.put(nums[n - 1], n - 1);
        map.put(nums[n - 1], 0);
        res.add(0);
        for (int i = n - 2; i >= 0 ; i--) {
            Integer low = treeMap.floorKey(nums[i]);
            if (low != null && low != nums[i]) {
                map.put(nums[i], map.get(low) + 1);
            } else {
                map.put(nums[i], 0);
            }
            //update
            Integer key = treeMap.ceilingKey(nums[i] + 1);
            while (key != null) {
                map.put(key, map.get(key) + 1);
                Integer high = treeMap.ceilingKey(key + 1);
                key = high;
            }
            res.add(map.get(nums[i]));
            treeMap.put(nums[i], i);
        }
        Collections.reverse(res);
        return res;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> output = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            int cc = 0;
            for(int j = i + 1 ; j < n; j++){
                if(nums[i] > nums[j])
                    cc++;
            }
            output.add(cc);
        }
        return output;
    }
}