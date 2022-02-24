import java.util.List;
import java.util.Stack;

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
        Stack<ListNode> stk = new Stack<>();
        ListNode start = new ListNode(0);
        start.next = head;
        head = start;
        while (head != null){
            stk.add(head);
            head = head.next;
        }
        for (int i = 0; i < n; i++) {
            stk.pop();
        }
        if (!stk.isEmpty()){
            ListNode temp = stk.peek();
            temp.next = temp.next.next;
        }
        return start.next;
    }
}
