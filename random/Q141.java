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
public class Q141 {
    /**
    * Floyd's Hare and Tortoise algorithm
    * Have two pointers, one moving at one node per iteration, 
    * other moving at two node per iteration. Eventually, 
    * if a loop exists they'll meet on that end.
    *
    */
    public boolean hasCycle(ListNode head) {
        ListNode prev=head, curr=head;
        
        while(curr!=null && curr.next!=null) {
            prev=prev.next;
            curr=curr.next.next;
            if(prev==curr) return true;
        }

        return false;
    }
}