import java.util.*;
/*
java.util.ArrayList.add(int index, E elemen) method inserts the specified element E at the specified position in this list.It shifts the element currently at that position (if any) and any subsequent elements to the right
*/
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class ZigzagTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null)
      return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean leftToRight = true; // firstLeftToRight then rightToLeft so initialize it to true
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currentLevel = new LinkedList<>(); // declare LinkedList for eachLevel List
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();

        // add the node to the current level based on the traverse direction
        if (leftToRight) // If level is of type LeftToRight add all elements from leftToRight
          currentLevel.add(currentNode.val);
        else // If level is of type RightToLeft add all elements from RightToLeft // Hence insert at index 0
          currentLevel.add(0, currentNode.val);

        // insert the children of current node in the queue
        if (currentNode.left != null)
          queue.offer(currentNode.left);
        if (currentNode.right != null)
          queue.offer(currentNode.right);
      }
      result.add(currentLevel);
      // reverse the traversal direction
      leftToRight = !leftToRight;
    }

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    root.right.left.left = new TreeNode(20);
    root.right.left.right = new TreeNode(17);
    List<List<Integer>> result = ZigzagTraversal.traverse(root);
    System.out.println("Zigzag traversal: " + result);
  }
}
