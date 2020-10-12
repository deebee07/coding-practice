/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * https://leetcode.com/explore/interview/card/amazon/77/linked-list/2976/
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

/*
Complexity Analysis

Time complexity : O(n+m)
*/


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}

/*
Time complexity : O(n + m)
Space complexity : O(1)

*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}