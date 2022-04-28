import java.util.Comparator;
import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for (ListNode node: lists){
            if(node != null){
                pq.add(node);
            }
        }
        ListNode cur = dummy;
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            cur.next = new ListNode(node.val);
            cur = cur.next;
            if(node.next != null){
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
}
