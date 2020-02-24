/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.

*
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root!=null){ 
            helper(root, 1);
        } else {
            return 0;
        }
        return minDepth;
    }
    
    public void helper(TreeNode node, int curDepth){
        if (node.left == null && node.right == null) {
            minDepth = Math.min(minDepth, curDepth);
        } else if (node.left ==null) {
            helper(node.right, curDepth+1);
        } else if (node.right ==null) {
            helper(node.left, curDepth+1);
        } else {
            helper(node.left, curDepth+1);
            helper(node.right, curDepth+1);
        }
    }
}