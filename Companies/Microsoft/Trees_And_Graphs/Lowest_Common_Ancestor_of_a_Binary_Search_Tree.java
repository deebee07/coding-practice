/*
https://leetcode.com/explore/interview/card/microsoft/31/trees-and-graphs/182/

*/

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * binary search tree (BST)
 * The lowest common ancestor is defined between two nodes p and q as the lowest node 
 * in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        
        // Value of p
        int pVal = p.val;
        
        // Value of q;
        int qVal = q.val;
        
         if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
}