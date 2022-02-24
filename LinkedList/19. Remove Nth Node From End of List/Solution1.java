/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre;
        while(n != 0){
            head = head.next;
            n--;
        }

        while(head != null){
            head = head.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return start.next;
    }
}
