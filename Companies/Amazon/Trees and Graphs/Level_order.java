/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        
         while ( !queue.isEmpty() ) { // runs eachIteration for a level
            // start the current level
            levels.add(new ArrayList<Integer>()); // forEach level add a baseArrayList to add all nodes
            // number of elements in the current level
            int level_length = queue.size();

            for(int i = 0; i < level_length; i++) {
                TreeNode node = queue.poll();
                // Add val of this node we are removing from queue
                levels.get(level).add(node.val);
                
                // but now add all the left and right of this node we are removing
                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
             level++;
         }
        return levels;
    }
}