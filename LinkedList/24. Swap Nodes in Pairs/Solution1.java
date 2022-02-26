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
        ListNode node1 = head, node2 = head.next, node0 = new ListNode(0),dummy;
        node0.next = head;
        dummy = node0;
        swapp(node0, node1,node2);
        while (node1 != null && node1.next != null && node1.next.next != null){
            node0 = node1;
            node1 = node1.next;
            node2 = node1.next;
            swapp(node0, node1,node2);
        }
        return dummy.next;
    }

    private void swapp(ListNode node0,ListNode node1, ListNode node2) {
        node1.next = node2.next;
        node2.next = node1;
        node0.next = node2;
    }
}
