/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1==null) return l2;
        if (l2==null) return l1;
        
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode dummyNode = new ListNode(-1);
        ListNode outputList = dummyNode;
        
        while(pointer1!=null && pointer2!=null){
            if(pointer1.val >pointer2.val) {
                
                outputList.next = pointer2;
                pointer2=pointer2.next;
                outputList=outputList.next;
            } else if (pointer1.val <pointer2.val) {
    
                outputList.next = pointer1;
                pointer1=pointer1.next;
                outputList=outputList.next;
            } else {
                outputList.next = pointer1;
                pointer1=pointer1.next;
                outputList=outputList.next;
                
                outputList.next = pointer2;
                pointer2=pointer2.next;
                outputList=outputList.next;
            }
            
        }
        
        if(pointer1!=null) {
            outputList.next=pointer1;
        }
        
        if(pointer2!=null) {
            outputList.next=pointer2;
        }
        
        return dummyNode.next;
        
    }
}