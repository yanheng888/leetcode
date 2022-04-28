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
    ListNode[] lists;
    public ListNode mergeKLists(ListNode[] lists) {
        this.lists = lists;
        return partition(0,lists.length-1);
    }

    private ListNode partition(int l, int r) {
        if(l == r){
            return lists[l];
        }
        if(l > r){
            return null;
        }
        int piv = l+(r-l)/2;
        ListNode node1 = partition(l,piv);
        ListNode node2 = partition(piv+1,r);
        return merge(node1,node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }
        if(node1.val < node2.val){
            node1.next = merge(node1.next,node2);
            return node1;
        }else{
            node2.next = merge(node2.next,node1);
            return node2;
        }
    }
}
