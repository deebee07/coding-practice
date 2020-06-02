/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
    Inverse of an empty tree is empty tree
    Inverse of a tree with. root r, subtrees (right, left) -> tree with root r, right subtree is inverse of left and left subtree is inverse of right subtree
    
    Time Complexity is Each tree is visited only once O(N) N is number of nodes in the tree.
    O(h) function calls will be placed on the stack h is height of tree
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}

/*
    Each node in the tree is visited/added to the queue only once, Time complexity is O(n)O(n), where n is the number of nodes in the tree.

    Space complexity is O(n), since in the worst case, queue will contain all nodes in one level of the binary tree. 
    For a full binary tree, the leaf level has [n/2] = O(N) leaves
*/
class Solution {
    public TreeNode invertTree(TreeNode root){
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            
            current.left = current.right;
            current.right = temp;
            
            if(current.left!=null) queue.add(current.left);
            if(current.right!=null) queue.add(current.right);
        }
        return root;
        
    }
}