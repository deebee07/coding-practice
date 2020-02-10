/*
Given a complete binary tree, count the number of nodes.
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.
*/
class Solution {
    public int countNodes(TreeNode root) {
      return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
    }
  }