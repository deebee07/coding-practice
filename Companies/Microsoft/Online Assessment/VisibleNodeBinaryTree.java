//https://leetcode.com/discuss/interview-question/546703/microsoft-oa-2020-count-visible-nodes-in-binary-tree
// Time: O(n)
// Space: O(n)
public int countVisibleNodes(TreeNode root) {
    return countVisibleNodes(root, Integer.MIN_VALUE);
}

private int countVisibleNodes(TreeNode node, int maxSoFar) {
    if (node == null) return 0;

    int count = 0;

    if (node.val >= maxSoFar) {
        count = 1;
        maxSoFar = node.val;
    }

    return count + countVisibleNodes(node.left, maxSoFar) + countVisibleNodes(node.right, maxSoFar);
}