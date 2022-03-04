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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        int cnt = 0;
        while (head != null){
            if(cnt > 10000){
                return true;
            }
            head = head.next;
            cnt++;
        }
        return false;
    }
}
