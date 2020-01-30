/*
https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2375/
https://leetcode.com/problems/maximum-depth-of-binary-tree/
*/

class Solution {
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      } else {
        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);
        return Math.max(left_height, right_height) + 1;
      }
    }
  }


/**
 * MIN DEPTH
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public int minDepth(TreeNode root) {
    if(root==null){return 0;}
    if(root.left==null){return minDepth(root.right) +1;}
    if(root.right==null){return minDepth(root.left)+1;}
    return Math.min(minDepth(root.left),minDepth(root.right))+1;
  }
  }