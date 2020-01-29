/*
https://leetcode.com/problems/inorder-successor-in-bst/submissions/
*/

public class Solution {
    TreeNode target = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      if (root == null) 
          return null;
      TreeNode n = inorderSuccessor(root.left, p);
      if (n != null)
          return n;
      if (target == null) {
          if (root.val == p.val) 
              target = root; 
      } else {
          return root;
      }
      return inorderSuccessor(root.right, p);
  } }