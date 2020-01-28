/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
public class Codec {
    
    // Encodes integer to bytes string
    public String intToString(int x) {
      char[] bytes = new char[4];
      for(int i = 3; i > -1; --i) {
        bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
      }
      return new String(bytes);
    }
  
    // Decodes bytes string to integer
    public int stringToInt(String bytesStr) {
      int result = 0;
      for(char b : bytesStr.toCharArray()) {
        result = (result << 8) + (int)b;
      }
      return result;
    }
  
  // Encodes a tree to a list. POSTORDER IS LEFT, RIGHT, NODE.VAL
  public void postorder(TreeNode root, StringBuilder sb) {
      if (root == null) return;
      postorder(root.left, sb);
      postorder(root.right, sb);
      sb.append(intToString(root.val));
  }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
      postorder(root, sb);
      return sb.toString();
    }
  
    // Decodes list to tree.
    public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
      if (nums.isEmpty()) return null;
      int val = nums.getLast();
      if (val < lower || val > upper) return null;

      nums.removeLast();
      TreeNode root = new TreeNode(val);
      root.right = helper(val, upper, nums);
      root.left = helper(lower, val, nums);
      return root;
    }

  // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
      int n = data.length();
      for(int i = 0; i < (int)(n / 4); ++i) {
        nums.add(stringToInt(data.substring(4 * i, 4 * i + 4)));
      }

      return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));