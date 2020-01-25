/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst
 */

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> listVal = new ArrayList<Integer>();
        return find(root, k, listVal);
    }
    
    
    public boolean find(TreeNode root, int k, List<Integer> listVal) {
        if (root==null)
            return false;
        
        if (listVal.contains(k-root.val))
            return true;
        
        listVal.add(root.val);
        return find(root.left, k, listVal) || find(root.right, k, listVal);
    }
}