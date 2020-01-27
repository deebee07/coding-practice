/*
https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
https://leetcode.com/explore/interview/card/microsoft/31/trees-and-graphs/153/
*/
// Recursive O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(list, root);
        
        return list;
    }
    
    public void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
        
    }
}
//Iterative using Stack

public class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // push current 
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
