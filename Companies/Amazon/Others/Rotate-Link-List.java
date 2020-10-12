https://leetcode.com/problems/rotate-list/discuss/884174/Java-100-Faster

/*
    Video explanation: https://youtu.be/Zt88upbcpmo
    https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3486/
    
*/
public class Solution {
    public ListNode rotateRight(ListNode head, int k) { 
        if (head == null) return null;
        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        k = k % size; //1 
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = head;
        ListNode newHead = p1.next;
        p1.next = null;
        return newHead;
    }
}