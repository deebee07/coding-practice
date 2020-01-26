/**
 * https://leetcode.com/explore/interview/card/microsoft/32/linked-list/184/
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode slowMover = head;
        ListNode fastMover = head.next;
        
        while (slowMover!=fastMover) {
            if (fastMover == null || fastMover.next ==  null) return false;
            slowMover = slowMover.next;
            fastMover = fastMover.next.next;
        }
        return true;
        
        
    }
}

//Other approach: Hash Table