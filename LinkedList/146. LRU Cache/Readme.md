
创建head tail 两个node,这两个node不移动，固定指向链表的头尾，这样就简化了解法，因为不用再考虑head.next.pre, head.pre.next是否为null

用map记录每个node,这样可以知道node是否存在
