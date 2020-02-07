/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/path-sum-ii/
 */
class Solution {
    
    private void recurseTree(TreeNode node, int remainingSum, List<Integer> pathNodes, List<List<Integer>> pathsList) {
        
        if (node == null) {
            return;
        }
        
        // Add the current node to the path's list
        pathNodes.add(node.val);
        
        // Check if the current node is a leaf and also, if it
        // equals our remaining sum. If it does, we add the path to
        // our list of paths
        if (remainingSum == node.val && node.left == null && node.right == null) {
            pathsList.add(new ArrayList<>(pathNodes));
        } else {
            
            // Else, we will recurse on the left and the right children
            this.recurseTree(node.left, remainingSum - node.val, pathNodes, pathsList);
            this.recurseTree(node.right, remainingSum - node.val, pathNodes, pathsList);
        }
        
        // We need to pop the node once we are done processing ALL of it's
        // subtrees.
        pathNodes.remove(pathNodes.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<Integer>();
        this.recurseTree(root, sum, pathNodes, pathsList);
        return pathsList;        
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
/*
Given a binary tree and a sum
    Find all root-to-leaf paths where each path's sum equals the given sum.
Note: A leaf is a node with no children.
*/
public class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(root, sum, res, path);
            return res;
        }
        
        public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
            if(root==null) return;
            path.add(root.val);
            
            //isLeafNode pathEndsHere so return as 1 pathEnds
            if(root.left==null && root.right==null ){
                if(root.val==sum)
                    res.add(new ArrayList<Integer>(path));
                return;
            }
            if(root.left!=null) {
                dfs(root.left, sum-root.val, res, path);
                path.remove(path.size()-1);
            }
            if(root.right!=null) {
                dfs(root.right, sum-root.val, res, path);
                path.remove(path.size()-1);
            }
            
        }
    }