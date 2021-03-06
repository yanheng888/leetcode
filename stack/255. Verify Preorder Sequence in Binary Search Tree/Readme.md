对于任意一个元素a，我们考虑以它为根的子树的序列表达，一定是类似... {a[xxxxxx][yyyyyy]} ...的形式。大括号内的是以a为根的子树的元素。我们可以知道x肯定都比a小，y肯定都比a大。那么y之后的元素呢？实际上它们肯定也会比a大。因为它们肯定是与a子树相对的右子树，或者a的更高层节点的某个右子树。因此，x之后的任何元素都应该比a大。

所以，我们遍历这个序列，一旦出现先后的两个元素满足 a<b（a和b不需要相邻），那么b之后出现的任何元素c必须要比a大，任何c<a的情况都是不合法的。

于是本题转化为：如何在遍历preorder的过程中，不断更新a<b，使得a不断得以抬升（即维护当前所有a<b配对中最大的a），一旦出现后续的c<a即可宣告false

怎么维护一个最新（尽量大）的a<b呢？那就是用栈来维护一个递减的序列。一旦遍历的过程中出现了preOrder[i]>Stack.top()，那就说明出现了递增序列，需要不断退栈直至保证栈本身仍然是递减的。在退栈的过程中，就不断遇到a<b的情况，借机可以抬高a。

[255. Verify Preorder Sequence in Binary Search Tree](https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/)
