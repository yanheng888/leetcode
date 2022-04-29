import java.util.List;

class MyLinkedList {
    ListNode head;
    int size;
    public MyLinkedList() {
        head = new ListNode(-1);
        size = 0;
    }

    public int get(int index) {
        ListNode node = getNode(index);
        if(node == null){
            return -1;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);

    }

    public void addAtTail(int val) {
         addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size || index < 0){
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode preNode = getNode(index - 1);
        if(preNode == null && head.next == null){
            head.next = newNode;
            size++;
            return;
        }
        if(preNode == null && head.next != null){
            preNode = head;
        }
        ListNode node = preNode.next;
        preNode.next = newNode;
        newNode.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index == 0){
            if(head.next != null){
                head.next = head.next.next;
                size--;
                return;
            }
        }
        if(index < 0){
            return;
        }
        ListNode preNode = getNode(index - 1);
        if(preNode == null || preNode.next == null){
            return;
        }
        ListNode node = preNode.next;
        preNode.next = node.next;
        size--;
    }

    public ListNode getNode(int index) {
        if(index < 0){
            return null;
        }
        int cnt = 0;
        ListNode cur = head.next;
        while (cur != null && cnt++ < index){
            cur = cur.next;
        }
        return cur;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
