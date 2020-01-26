/*
https://leetcode.com/problems/merge-k-sorted-lists/
*/

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /*
        Declare a Priority Queue with comparator (a, b) -> a.val-b.val (queue)
        Declare a dummyNode
        Point tail to dummyNode
        
        for(ListNode node: lists)
            if (node!=null)
                queue.add(node)
        
        */
        if (lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>((a,b) -> a.val-b.val);
        ListNode dummy = new ListNode(0);
        ListNode outputHead=dummy;
        
        for (ListNode node:lists) {
            if (node!=null)
                queue.add(node);
        }

        while (!queue.isEmpty()){

            ListNode priorityNode = queue.poll(); // important Node smallestNode remove
            outputHead.next = priorityNode;
            outputHead = outputHead.next; // move it forward to next important element
            
            if (outputHead.next!=null) //add the other elements in the queue
                queue.offer(outputHead.next); // offer() or add()
        }
        return dummy.next;
    }

}