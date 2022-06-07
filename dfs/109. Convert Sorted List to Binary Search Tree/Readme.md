**Solution: divide and conquer + dfs**

Notice:

- by observation, we can find the median is the root,the new median of [left,median] is left child of median, and the new median of [median.next,right] is right child of median. The median should be the right one of the middle two if there are even number of node. Thus, mid = left+(right-left+1)/2; [left,median] including median which is equal to add a node in left part; [median.next,null] including null which is equal to add a node in right part;

- In buildTree(),if there is only two nodes(ex only left node, right node), we want getMedian() return the left node since if it returns the right node, there will be stackoverflow

- in getMedian() ,when fast or fast.next = right break loop. Because we want to return left node as median if there is only two nodes
```
while(fast != right && fast.next != right){
    slow = slow.next;
    fast = fast.next;
    if(fast == null){
        break;
    }
    fast = fast.next;
}
```



Solution2:inorder dfs

Notice:

- Inorder dfs traverse a BST and print value of node, the print order will be ascending
