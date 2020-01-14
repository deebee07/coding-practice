BFS:
```
class Result {

    /*
     * Complete the 'treeBFS' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts TreeNode root as parameter.
     */
    public static List<Integer> treeBFS(TreeNode root) {
        /*
        Instantiate resultList
        initialize Queue.
        add(root)
            while(queue !isEmpty)
                take size of queue (0,size)
                iterate until queue is empty (0,size)
        */

        List<Integer> result = new ArrayList<Integer>();      
        Queue<TreeNode> queueT = new LinkedList<TreeNode>();
        queueT.add(root);

        while (!queueT.isEmpty()){
            TreeNode node = queueT.poll();
            result.add(node.value);

            if (node.left!=null) {
                queueT.add(root.left);
            }
            if (node.right!=null) {
                queueT.add(root.right);
            }

        }
        return result;
    }

}
```

DFS: PreOrder


```
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// TreeNode class for a binary tree node
class TreeNode {
  public int value;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int value){
    this.value = value;
  }
}

class Result {

    /*
     * Complete the 'preDFS' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts TreeNode root as parameter.
     */

    public static List<Integer> preDFS(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            helper(root, result);
            return result;
    }

    public static void helper(TreeNode root, List<Integer> result) {

        if (root ==null) return;
        result.add(root.value);
        helper(root.left, result);
        helper(root.right, result);

    }

}
```


DFS: InOrder
```
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// TreeNode class for a binary tree node
class TreeNode {
  public int value;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int value){
    this.value = value;
  }
}

class Result {

    /*
     * Complete the 'inDFS' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts TreeNode root as parameter.
     */

    public static List<Integer> inDFS(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }

    public static void helper(TreeNode root, List<Integer> result) {

        if (root ==null) return;
        helper(root.left, result);
        result.add(root.value);
        helper(root.right, result);

    }

    

}
```


DFS: PostOrder
```
class Result {

    /*
     * Complete the 'postDFS' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts TreeNode root as parameter.
     */

    public static List<Integer> postDFS(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }

    public static void helper(TreeNode root, List<Integer> result) {

        if (root ==null) return;
        helper(root.left, result);
        helper(root.right, result);
        result.add(root.value);
    
    }


}```
