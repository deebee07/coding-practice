/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/explore/interview/card/google/60/linked-list-5/3064/
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pointer = head;
        ListNode nodeToDelete = null;
        int counter = 1;
        while(pointer!=null) {
            if (counter==(n+1)) {
                nodeToDelete = head;
            } else if (counter>(n+1)) {
                nodeToDelete = nodeToDelete.next;
            }
            counter++;
            pointer = pointer.next;
        }
        nodeToDelete.next = nodeToDelete.next.next;
        return head;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    }