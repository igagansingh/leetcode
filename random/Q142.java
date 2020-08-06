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
public class Q142 {
    public ListNode detectCycle(ListNode head) {
        /**
        * Follow up on Floyd's Hare and Tortoise algorithm, 
        * After finding the point where slow and fast pointer meets,
        * we reset one of the pointer to start from the beginning
        * We move both the pointers simultaneously until they meet again. 
        * That'll be the start point of the loop.
        *
        */
        ListNode prev=head, curr=head, start=null;
        
        while(curr!=null && curr.next!=null) {
            prev=prev.next;
            curr=curr.next.next;
            if(prev==curr) {start=prev;break;}
        }
        
        if(start==null) return start;
        
        curr=head;
        while(curr!=start) {curr=curr.next;start=start.next;}
        return curr;
    }
}