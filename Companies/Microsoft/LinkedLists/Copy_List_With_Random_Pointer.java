/*
https://leetcode.com/explore/interview/card/microsoft/32/linked-list/168/
https://leetcode.com/problems/copy-list-with-random-pointer/solution/
*/

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

ALGORITHM:
    1. Start traversing the graph from head node. (linked structure as a graph)
    2. IF already have a cloned copy of the current node in the visited dictionary, we use the cloned node reference.
    3. we don't have a cloned copy in the visited dictionary, we create a new node 
    
    Time Complexity: O(N) where N is the number of nodes in the linked list.
*/
class Solution {
    // MAP holds OLD nodes as keys and NEW nodes as its values.
    HashMap<Node, Node> visited = new HashMap<Node, Node>();
    
    public Node copyRandomList(Node head) {
        
        if (head == null) {
            return null;
        }
        // If ALREADY processed the current node, then we RETURN the cloned version
        if (this.visited.containsKey(head)) {
            return this.visited.get(head);
        }
        
        // Create a new node with the value same as old node
        Node node = new Node(head.val, null, null);
        this.visited.put(head, node);
        
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);
        return node;
    }
}



/*
Other solution
    Cloned keys pointers are not updated so do it by
        get(node).next = map.get(node.next)
        get(node).random = map.get(node.random)
        node = node.next
*/

public class Solution {
    public Node copyRandomList(Node head) {
            if(head == null)
                return null;

            Map<Node, Node> map = new HashMap<>();
            Node node = head; //here is the headNode
            while(node != null) {
                map.put(node, new Node(node.val, node.next, node.random));
                node = node.next;
            }

            node = head;
            while(node != null) {
                map.get(node).next = map.get(node.next);
                map.get(node).random = map.get(node.random);
                node = node.next;
            }

            return map.get(head);
        }
}