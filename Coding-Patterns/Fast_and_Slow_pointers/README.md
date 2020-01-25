#### Fast & Slow Pointers/Hare & Tortoise algorithm

* Uses **2 pointers** that iterate through the array (or sequence/LinkedList) at **different speeds**.
    * Useful for cyclic LinkedLists or arrays. 
        * moving at different speeds, the algorithm proves that the **two pointers** are bound to meet. 
        * **Fast pointer** should **catch** the **slow pointer** once both the pointers are in a **cyclic loop**
        
#### Example 1: Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
#### Example 2: Given the head of a LinkedList with a cycle, find the length of the cycle.
#### Example 3: Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
#####  Solution:


Space O(1)
Time: O(N)
N: Total Number of Nodes in LinkedList
```
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class LinkedListCycleStart {
  // middleElement of LinkList No Cycle slow Would be middle
  public static ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public static ListNode findCycleStart(ListNode head) {
    int cycleLength = 0;
    // find the LinkedList cycle
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) { // found the cycle
        cycleLength = calculateCycleLength(slow);
        break;
      }
    }

    return findStart(head, cycleLength);
  }

  private static int calculateCycleLength(ListNode slow) {
    ListNode current = slow;
    int cycleLength = 0;
    do {
      current = current.next;
      cycleLength++;
    } while (current != slow);
    
    return cycleLength;
  }

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

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
  }
}
```
