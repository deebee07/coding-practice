/*
slow would return the middle element as slow moves 1 step; fast moves 2 step
*/
class Solution {
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
        }
    
        return slow;
      }
}
