/**
 * https://leetcode.com/explore/interview/card/apple/345/linked-list/2022/
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
        ListNode outputList = dummyNode; // dummyNode to start ourList
        
        while(pointer1!=null && pointer2!=null){ // we have elements to compare between both list
            if(pointer1.val >pointer2.val) { // whichever is small put that first here p2 is
                
                outputList.next = pointer2;
                pointer2=pointer2.next;
                outputList=outputList.next;
            } else if (pointer1.val <pointer2.val) { // whichever is small put that first here p1 is
    
                outputList.next = pointer1;
                pointer1=pointer1.next;
                outputList=outputList.next;
            } else { // if equal add both and move both to next and output by 2
                outputList.next = pointer1;
                pointer1=pointer1.next;
                outputList=outputList.next;
                
                outputList.next = pointer2;
                pointer2=pointer2.next;
                outputList=outputList.next;
            }
            
        }
        
        if(pointer1!=null) { // if any 1 list is empty just put the other in output as is
            outputList.next=pointer1;
        }
        
        if(pointer2!=null) { // if any 1 list is empty just put the other in output as is
            outputList.next=pointer2;
        }
        
        return dummyNode.next;
        
    }
}