/*
https://leetcode.com/problems/linked-list-cycle-ii/
*/

class Solution {

    private static ListNode findStart(ListNode head, int cycleLength) {
        ListNode pointer1 = head, pointer2 = head;
        // move pointer2 ahead 'cycleLength' nodes
        while (cycleLength > 0) {
          pointer2 = pointer2.next;
          cycleLength--;
        }
    
        // increment both pointers until they meet at the start of the cycle
        while (pointer1 != pointer2) {
          pointer1 = pointer1.next;
          pointer2 = pointer2.next;
        }
    
        return pointer1;
      }
    
}

/*
Define two pointers slow and fast. 
Both start at head node, fast is twice as fast as slow.
If it reaches the end it means there is no cycle, otherwise eventually it will eventually catch up to slow pointer somewhere in the cycle.
https://www.youtube.com/watch?v=zbozWoMgKW0
Let the distance from the first node to the the node where cycle begins be A
Let say the slow pointer travels travels A+B. 
Fast pointer must travel 2A+2B to catch up. 
Cycle size is N. 
Full cycle is also how much more fast pointer has traveled than slow pointer at meeting point.
https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.
A+B+N = 2A+2B
N=A+B
From our calculation slow pointer traveled exactly full cycle when it meets fast pointer, and since originally it travled A before starting on a cycle, it must travel A to reach the point where cycle begins! We can start another slow pointer at head node, and move both pointers until they meet at the beginning of a cycle.
*/
public class Solution {
            public ListNode detectCycle(ListNode head) {
                ListNode slow = head;
                ListNode fast = head;
        
                while (fast!=null && fast.next!=null){
                    fast = fast.next.next;
                    slow = slow.next;
                    
                    if (fast == slow){ // we have a cycle Slow moves by 1 node fast moves by 2 node they meet at a node. slow has moved a+b whereas fast has moved a+2b a being the distance to the cycleStart Node
                        ListNode slow2 = head; 
                        while (slow2 != slow){
                            slow = slow.next;
                            slow2 = slow2.next;
                        }
                        return slow;
                    }
                }
                return null;
            }
        }


// Approach 2:

/**
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
    public ListNode findStart(ListNode head, int cycleLength) {
          ListNode pointer1 = head, pointer2 = head;
          // move pointer2 ahead 'cycleLength' nodes
          while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
          }

          // increment both pointers until they meet at the start of the cycle
          while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
          }

          return pointer1;
      }
  
      public int calculateCycleLength(ListNode slow) {
          ListNode current = slow;
          int cycleLength = 0;
          do {
            current = current.next;
            cycleLength++;
          } while (current != slow);

          return cycleLength;
      }
      public ListNode detectCycle(ListNode head) {
              ListNode slow = head;
              ListNode fast = head;
      
              while (fast!=null && fast.next!=null){
                  fast = fast.next.next;
                  slow = slow.next;
                  
                  if (fast == slow){ // cycleFound

                      int cycleLength = calculateCycleLength(slow);
                      return findStart(head, cycleLength);
                  }
              }
              return null;
          }
  
  



      }