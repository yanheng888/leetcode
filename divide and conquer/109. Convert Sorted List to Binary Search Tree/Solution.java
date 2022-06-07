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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head,null);
    }
    public TreeNode buildTree(ListNode left,ListNode right) {
        if(left == right){
            return null;
        }
        ListNode mid = getMedian(left,right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left,mid);
        root.right = buildTree(mid.next,right);
        return root;
    }

    private ListNode getMedian(ListNode left,ListNode right) {
        ListNode slow = left, fast = left;
        while(fast != null && fast != right && fast.next != right){
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                break;
            }
            fast = fast.next;
        }
        return slow;
    }
}
