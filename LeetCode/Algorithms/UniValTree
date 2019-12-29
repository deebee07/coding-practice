/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/univalued-binary-tree/
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (root.left !=null && root.left.val != root.val) {
            return false;
        }
        
        if (root.right !=null && root.right.val != root.val) {
            return false;
        }
        
        if (isUnivalTree(root.left) && isUnivalTree(root.right)) {
            return true;
        }
        return false;
    }
}
