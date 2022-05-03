/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        if(l1 == null){
            return l1;
        }
        if(l2 == null){
            return l2;
        }
        int carry = 0;
        ListNode cur = l3;
        ListNode tail = cur;
        while (l1 != null || l2 != null || carry!=0){
            int n1 = l1==null ? 0:l1.val;
            int n2 = l2==null ? 0:l2.val;
            
            int sum = n1+n2+carry;
            cur.next = new ListNode((sum%10));
            cur = cur.next;
            carry = sum/10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }

        }
        
        return l3.next;
    }
}
