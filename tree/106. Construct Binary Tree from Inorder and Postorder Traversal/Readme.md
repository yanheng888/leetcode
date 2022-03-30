本题和 105. Construct Binary Tree from Preorder and Inorder Traversal 一样的思路。根据后续遍历的性质，postorder数组的最后一个元素就是根节点。在inorder数组里面通过之前构建的hash映射找到这个根节点，就可以将整个inorder数组分成左右两部分，分别构造左子树和右子树。

postorder数组的拆分方法：根据inorder数组拆分得到的左右子树的元素数目，来确定postorder序列里前面多少个元素属于左子树


```
int pos = map.get(postorder[b]);
root.left = dfs(postorder, a, a + pos - m - 1, inorder, m, pos - 1);
root.right = dfs(postorder, a+pos-m, b-1, inorder, pos+1, n);
```

此处重点在于理解postorder[],左右边界。postorder 左区间，右区间的元素个数等于左子树，右子树的元素个数。pos-m实际上为左子树的个数，pos-m-1则表示左区间中最右边的一个元素在左区间的下标


https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72/
