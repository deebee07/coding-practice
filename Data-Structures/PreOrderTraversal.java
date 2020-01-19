/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();
        helperPre(root, resultList);
        return resultList;
    }
    
    
    public void helperPre(TreeNode node, List<Integer> resultList) {
        if (node==null) return;
        resultList.add(node.val);
        helperPre(node.left, resultList);
        helperPre(node.right, resultList);
    }
}