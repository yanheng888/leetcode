class LRUCache {
    ListNode head;
    ListNode tail;
    int capacity;
    ListNode[] map;
    public LRUCache(int capacity) {
        this.head = new ListNode(-1,-1,null,null);
        this.tail = new ListNode(-1,-1,null,null);
        this.head.next = this.tail;
        this.tail.pre = this.head;
        map = new ListNode[100000];
        this.capacity = capacity;
    }

    public int get(int key) {
        ListNode node = map[key];
        if(node != null){
            remove(node);
            addToFirst(node);
            return node.val;
        }
        return -1;
    }


    public void put(int key, int value) {
        ListNode node = map[key];
        if(node == null){
            if(capacity <= 0){
                node = map[tail.pre.key];
                map[tail.pre.key] = null;
                remove(node);
                node.key = key;
                node.val = value;
            }else{
                node = new ListNode(key,value,null,null);
            }
            addToFirst(node);
            map[key] = node;
        }else{
            remove(node);
            addToFirst(node);
            node.val = value;
        }
    }

    private void addToFirst(ListNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        capacity--;
    }

    private void remove(ListNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
        capacity++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode pre;

    public ListNode(int key, int val, ListNode next, ListNode pre) {
        this.key = key;
        this.val = val;
        this.next = next;
        this.pre = pre;
    }
}
