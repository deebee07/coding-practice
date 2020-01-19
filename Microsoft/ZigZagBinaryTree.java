/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null)
            return result;
        helper(queue, result, root);
        return result;
    }
    
    public void helper(Queue<TreeNode> queue, List<List<Integer>> result, TreeNode node) {
        
        if (node == null) return;
        queue.offer(node);
        boolean leftToRight = true;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> listLevel = new ArrayList<Integer>();
            
            for (int i=0; i<size;i++) {
                TreeNode currentNode = queue.poll();
                if (leftToRight) listLevel.add(0, currentNode.val);
                else listLevel.add(currentNode.val);

                if (currentNode.right != null)
                    queue.offer(currentNode.right);
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
            }
            result.add(listLevel);
            leftToRight = !leftToRight;
            }
            
        }
}