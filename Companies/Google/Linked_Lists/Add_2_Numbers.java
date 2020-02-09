/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/explore/interview/card/google/60/linked-list-5/3063/
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0; // make carry as 0
        ListNode dummyNode = new ListNode(-1); // create a dummyHead so eventually return nextNode to dummyNode
        
        ListNode node = dummyNode;
        while (l1!=null || l2!=null) { // untill either l1 is not done or l2 is not done
            
            int x = (l1!=null) ? l1.val: 0; // if l1 is null: add 0
            int y = (l2!=null) ? l2.val: 0; // if l2 is null: add 0
            int add = carry + x + y; //((l1!=null) ? l1.val : 0) + ((l2!=null) ? l2.val : 0) + carry
            carry = add/10; // new Carry
            
            node.next = new ListNode(add%10); // set one's digit
            node = node.next; // make next as our new node as we need to set until we set all
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
            
        }
        if (carry > 0) { // for last digit of number if carry
            node.next = new ListNode(carry);
        }
        return dummyNode.next; // always return dummyNext as dummy was just to initialize link list
    }
}