/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/two-sum-bsts/
 */
class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        
        /* 
            if root1 or root2 is null return false
            curSum = root1.val + root.val
            if (curSum>target) // it would be in left of either one: as in BST: left is small
            return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target)
            else if (curSum<target)
            return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target)
            else //equal
            return true;
        */
        if (root1 == null || root2 == null) return false; 
        int sum = root1.val + root2.val;
        if (sum == target) return true;
        else if (sum > target) return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target);
        else return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target);
    }
}

/* 
Inorder traversal then check

class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null)
            return false;
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        inorder(root1, l1);
        inorder(root2, l2);
        return check(l1, l2, target) || check(l2, l1, target);
    }
    
    private boolean check(List<Integer> l1, List<Integer> l2, int target) {
        int i = 0, j = l2.size() - 1;
        while (i < l1.size() && j >= 0 && l1.get(i) <= l2.get(j)) {
            int sum = l1.get(i) + l2.get(j);
            if (sum == target)
                return true;
            if (sum < target)
                i++;
            else
                j--;
        }
        return false;
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
*/