设一个元素的下标是 \textit{index}index，我们可以通过两次煎饼排序将它放到尾部：

第一步选择 k=index+1，然后反转子数组 arr[0...k−1]，此时该元素已经被放到首部。

第二步选择 k=n，其中 n 是数组 arr 的长度，然后反转整个数组，此时该元素已经被放到尾部。

通过以上两步操作，我们可以将当前数组的最大值放到尾部，然后将去掉尾部元素的数组作为新的处理对象，重复以上操作，直到处理对象的长度等于一，此时原数组已经完成排序，且需要的总操作数是 2 \times (n - 1)2×(n−1)，符合题目要求。如果最大值已经在尾部，我们可以省略对应的操作。


链接：https://leetcode-cn.com/problems/pancake-sorting/solution/jian-bing-pai-xu-by-leetcode-solution-rzzu/

