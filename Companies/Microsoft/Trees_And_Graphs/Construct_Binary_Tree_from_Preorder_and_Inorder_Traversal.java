/*
https://leetcode.com/explore/interview/card/microsoft/31/trees-and-graphs/196/
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/
*/
/*
inorder and preorder are given make binaryTree

declare preorderIndex as 0 (as this will be root)
declare inorderMap with key as nodeVal and value as its index
declare preorderArray for classInstance

put preorderArray as classInstance preorderArray

inorderIndex initialize to 0

for Integer i in inOrderArray
    Map.put(i, inorderIndex)
    inorderIndex++
    
helper(0, inorderLength)


helper (inorderLeft, inorderRight) returns a TreeNode
    if inorderLeft == inorderRight return null
    
    preorderArray[preorderIndex] is rootNode so create new node(preorderArray[preorderIndex])
    int index_inorder = Map.get(preorderArray[preorderIndex]);
     
     preorderIndex++;
     
     root.left = helper(inorderLeft, index_inorder)
     root.right = helper(index_inorder+1, inorderRight)
     return root
     
*/

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
    
    int pre_idx = 0; // Pre-order index
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>(); //indexMap with key as nodeVal and value as countIndex


public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
    
        // build a inorder hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
    
        return helper(0, inorder.length);
}

  public TreeNode helper(int in_left, int in_right) { // inorderLeft and inorderRight
        // if there is no elements to construct subtrees
        if (in_left == in_right)
          return null;

        // pick up pre_idx element as a root
        int root_val = preorder[pre_idx]; // THIS IS ROOT WHICH IS OF PREORDER
        TreeNode root = new TreeNode(root_val); //CREATE NODE

        // root splits inorder list
        // into left and right subtrees
        int index = idx_map.get(root_val); //GET INDEX OF SAME IN INORDER

        // recursion 
        pre_idx++;
      
        // build left subtree
        root.left = helper(in_left, index);

        // build right subtree
        root.right = helper(index + 1, in_right);
      
        return root;
}
}

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
    
    int pre_idx = 0; // Pre-order index
    int[] preorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>(); //indexMap with key as nodeVal and value as countIndex


public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        // build a inorder hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
    
        return helper(0, inorder.length);
}

  public TreeNode helper(int in_left, int in_right) { // inorderLeft and inorderRight
        // if there is no elements to construct subtrees
        if (in_left == in_right)
          return null;

        // pick up pre_idx element as a root
        int root_val = preorder[pre_idx]; // THIS IS ROOT WHICH IS OF PREORDER
        TreeNode root = new TreeNode(root_val); //CREATE NODE

        // root splits inorder list
        // into left and right subtrees
        int index = idx_map.get(root_val); //GET INDEX OF SAME IN INORDER

        // recursion 
        pre_idx++;
      
        // build left subtree
        root.left = helper(in_left, index);

        // build right subtree
        root.right = helper(index + 1, in_right);
      
        return root;
}
}