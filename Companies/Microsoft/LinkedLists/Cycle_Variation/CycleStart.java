class Solution {

    private static int calculateCycleLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
          current = current.next;
          cycleLength++;
        } while (current != slow);
        
        return cycleLength;
      }
}