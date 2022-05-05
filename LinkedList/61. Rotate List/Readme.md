**Solution: **

直接改变tail.next, newHeadPre.next 两个指针来生成新的list

**Solution2: **

遍历newHead之后的list,反转list,之后将newTail.next=head来生成新的list

Notice:
- edge case 1: (k%len) == 0, return head
- edge case 2: head == null, reutnr null
