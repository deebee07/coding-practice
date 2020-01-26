/**
 * https://leetcode.com/explore/interview/card/microsoft/32/linked-list/212/
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 * if list A and list B have the same length
 *      this solution will terminate in no more than 1 traversal
 * if both lists have different lengths, 
 *      this solution will terminate in no more than 2 traversals -- 
 *          in the second traversal, swapping a and b synchronizes a and b before the end of the second traversal. 
 *          By synchronizing a and b I mean both have the same remaining steps in the second traversal so that it's guaranteed for them to reach the first intersection node
 *          or reach null at the same time (technically speaking, in the same iteration) -- see Case 2 (Have Intersection & Different Len) and Case 4 (Have No Intersection & Different Len).
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
        
        return a;
    }
    }