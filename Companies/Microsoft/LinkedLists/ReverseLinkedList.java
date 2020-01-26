/*
https://leetcode.com/explore/interview/card/microsoft/32/linked-list/169/

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //Iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        
        while (current!=null) {
            next = current.next;
            //Now update pointers
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
        
    }
}

//Recursive
class Solution {
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}
}