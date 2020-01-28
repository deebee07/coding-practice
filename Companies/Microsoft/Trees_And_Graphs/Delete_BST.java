/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Three possible situations:
 *      1. Node is a leaf, and one could delete it straightforward : node = null
 *      2. Node is not a leaf and has a right child. Then the node could be replaced by its successor which is somewhere     *    lower in the right subtree. Then one could proceed down recursively to delete the successor.
 *      3. Node is not a leaf, has no right child and has a left child. That means that its successor is somewhere upper in the tree but we don't want to go back. Let's use the predecessor here which is somewhere lower in the left subtree. 
 replaced by its predecessor an
 https://leetcode.com/problems/delete-node-in-a-bst/
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
    
        // delete from the right subtree
        if (key > root.val) root.right = deleteNode(root.right, key);
        // delete from the left subtree
        else if (key < root.val) root.left = deleteNode(root.left, key);
        // delete the current node
        else {
          // the node is a leaf
          if (root.left == null && root.right == null) root = null;
          // the node is not a leaf and has a right child
          else if (root.right != null) {
            root.val = successor(root);
            root.right = deleteNode(root.right, root.val);
          }
          // the node is not a leaf, has no right child, and has a left child    
          else {
            root.val = predecessor(root);
            root.left = deleteNode(root.left, root.val);
          }
        }
        return root;
      }
        
        public LinkedList<Integer> inorder(TreeNode root, LinkedList<Integer> arr) {
            if (root == null) return arr;
            inorder(root.left, arr);
            arr.add(root.val);
            inorder(root.right, arr);
            return arr;
        }
        /*
            successor is right then all left
        */
        public int successor(TreeNode root) {
            root = root.right;
            while (root.left != null) root = root.left;
            return root.val;
        }
        
        /*
            predecessor is left then all right
        */
        public int predecessor(TreeNode root) {
            root = root.left;
            while (root.right != null) root = root.right;
            return root.val;
        } 
    }