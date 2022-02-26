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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode subRes = swapPairs(head.next.next);
        ListNode headNext = head.next;
        headNext.next = head;
        head.next = subRes;
        return headNext;
    }

    private void swapp(ListNode node0,ListNode node1, ListNode node2) {
        node1.next = node2.next;
        node2.next = node1;
        node0.next = node2;
    }
}
