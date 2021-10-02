import java.util.ArrayList;
import java.util.Stack;


//  class ListNode {
//       int val;
//       ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            n++;
        }
        int[] ret = new int[n];
        Stack<int[]> stack = new Stack<>();
        int i = 0;
        while (head != null){
            cur = head;
            while(!stack.isEmpty() && stack.peek()[0] < cur.val){
                int idx = stack.pop()[1];
                ret[idx] = cur.val;
            }
            ret[i] = 0;
            stack.add(new int[]{cur.val, i});
            i++;
            head = head.next;
        }

        return ret;
    }
}
