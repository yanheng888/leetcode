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
//    public ListNode sortList(ListNode head) {
//        return sortList(head,null);
//    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head, fast = head, temp = head;
        while (fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left,right);
    }

    private ListNode merge(ListNode head, ListNode tail) {
        ListNode cur = new ListNode(0);
        cur.next = head;
        ListNode res = cur;
        while(head != null && tail != null){
            if(head.val < tail.val){
                cur.next = head;
                head = head.next;
            }else{
                cur.next = tail;
                tail = tail.next;
            }
            cur = cur.next;
        }
        if(head == null){
            cur.next = tail;
        }
        if(tail == null){
            cur.next = head;
        }
        return res.next;
    }
}
