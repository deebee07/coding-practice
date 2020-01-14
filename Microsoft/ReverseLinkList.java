class ListNode {
    int value = 0;
    ListNode next;
  
    ListNode(int value) {
      this.value = value;
    }
  }
  
  public class LinkedListReverse {
   public static ListNode  reverseLinkedList(ListNode head) {
      if (head ==null) throw new IllegalArgumentException("head sent as null");
      ListNode current = head;
      ListNode previous = null;
      ListNode next = null;
      
      while (current !=null) {
          
          next = current.next;
          current.next = previous;
          previous = current;
          current = next;
      }
      
      return previous;
       
   }
  
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(6);
  
      head = LinkedListReverse.reverseLinkedList(head);
      System.out.println("Reverse Link List");
      while (head!=null) {
          System.out.println(head.value);
          head = head.next;
      }
    }
  }