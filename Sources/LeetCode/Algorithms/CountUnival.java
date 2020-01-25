/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Google Coding Interview - Universal Value Tree Problem
 * https://leetcode.com/articles/count-univalue-subtrees/


isUnival(Node root)
Time : O(n)

countUnivalSubtrees
Time: O(n*2)
 */
class Solution {
    public int countUnivalSubtrees(TreeNode root) {
       if (root == null)
            return 0;
        
        int totalCount = countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
        if (isUnival(root)) {
            totalCount += 1;
        }
        return totalCount;

    }
    
    public boolean isUnival(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (root.left !=null && root.left.val != root.val) {
            return false;
        }
        
        if (root.right !=null && root.right.val != root.val) {
            return false;
        }
        
        if (isUnival(root.left) && isUnival(root.right)) {
            return true;
        }
        return false;
    }
}
