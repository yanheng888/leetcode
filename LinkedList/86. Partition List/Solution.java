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
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);
        ListNode p = h1;
        ListNode q = h2;
        while(head != null){
            if(head.val < x){
                p.next = new ListNode(head.val);
                p = p.next;
            }else{
                q.next = new ListNode(head.val);
                q = q.next;
            }
            head = head.next;
        }
        p.next = h2.next;
        q.next = null;
        return h1.next;
    }
}
