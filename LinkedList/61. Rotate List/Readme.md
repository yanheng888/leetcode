**Solution: **

直接改变tail.next, newHeadPre.next 两个指针来生成新的list

**Solution2: **

遍历newHead之后的list,反转list,之后将newTail.next=head来生成新的list
