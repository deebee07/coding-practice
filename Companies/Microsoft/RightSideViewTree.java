/*
https://leetcode.com/problems/binary-tree-right-side-view/submissions/
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        dfs(root,res,1);
        
        return res;
    }
    
    public void dfs(TreeNode node,List<Integer> res,int level){
        if(node == null)
            return;
        if(level > res.size()){
            res.add(node.val);
        }
        dfs(node.right,res,level+1);
        dfs(node.left,res,level+1);
    }
}