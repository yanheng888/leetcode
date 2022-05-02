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
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int flag = 0;
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            return null;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
