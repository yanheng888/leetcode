**901.Online-Stock-Span**
题意就是说，对于数组中的任何元素A[i]，需要回溯看它左边邻接有多少个连续的元素小于等于A[i]。显然应该有o(n)的单调栈解法。

我们尝试一下如果是维护一个递减的序列，比如5,4,3,2,1，显然每个元素能往左回溯的距离就只有1（就是它本身），因为栈顶元素比自己大。

接下来如果新元素是3，我们应该尝试退栈，得到5,4,[3,2,1],3（中括号内的部分就是退栈的元素）。退栈合理与否的关键，在于被退栈的元素以后是否还有利用价值。在这里，[3,2,1]是被3逼退的，设想加入之后再出现了X，只要X比3大，自然X也会比这些已经退栈的[3,2,1]都大。所以退栈的这些元素以后是不用被记录的，对于X而言可以直接退栈到4或者更前面的位置。

所以方法就是维护递减的单调栈。每次加入新元素的时候，都可以通过退栈操作（也可能不退）来更新得到这个新元素对应的配对位置（也就是左边邻接最远的小于等于自身的元素）。
