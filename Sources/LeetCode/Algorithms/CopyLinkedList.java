/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
https://leetcode.com/problems/copy-list-with-random-pointer/
*/
class Solution {
    // Old node reference as "key" and new node reference as the "value"
    HashMap<Node, Node> visited = new HashMap<Node, Node>();
    
    public Node copyRandomList(Node head) {
        
        // if headNode == null return null
        if (head == null) {
            return null;
        }
        
        // initialize oldNode as head if we have a node
        Node oldNode = head;
        
        // Create a new node of headValue and mark it as visited
        // HashMap stores key as oldNode pointer and value as clonedNode pointer
        // Hence, push headNode old as key and headNode new as value
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);
        
        
        while (oldNode != null) { // Traverse linkList untill end
            
            newNode.random = this.getClonedNode(oldNode.random); // pass oldNode Random pointer
            newNode.next = this.getClonedNode(oldNode.next); // pass oldNode next pointer
            
            oldNode = oldNode.next; 
            newNode = newNode.next;
        }
        
        return this.visited.get(head);
        
    }
    
    public Node getClonedNode(Node node) {
        // If node exists then
        if (node != null) {
          // Check if already inVisited
          if (this.visited.containsKey(node)) {
            // If its in the visited dictionary then return the new node reference from the dictionary
            return this.visited.get(node);
          } else {
            this.visited.put(node, new Node(node.val, null, null)); // Make clonedNodePointers to null
            return this.visited.get(node);
          }
        }
        return null;
      }
}
