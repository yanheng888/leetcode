**解法1： PQ**

此题的常规解法是类似BFS。对于当前ugly number的某一个元素k，由它可以生成另外三个ugly number，分别是k*2,k*3,k*5，于是将这三个数添加进一个小顶堆的优先队列，自动冒出候选者中的最小值。注意需要做去重。因为每次弹出一个数，会加入三个数，这样的时间复杂度是o(3Nlog3N).

**解法2： DP**

事实上有更好的解法，时间复杂度是o(N).上面的解法的问题在于，对于k*2,k*3,k*5，他们的差距可能很大，加入BFS队列的时候也并不都放在最后，可能需要排序才能插入到合适的位置。如何避免这样的排序呢？也就是说，如何生成一个新丑数使得它恰好就是下一个最小的？

我们思考，对于任何丑数，它只能由某一个丑数乘以2，或者某一个丑数乘以3，或者某一个丑数乘以5得到。OK，假设有三个丑数a,b,c,它们对应的a*2,b*3,c*5,如果这三个都是新丑数，我们必然就只先取最小的那个，假设是a*2，OK，可以放入队列。那么这时候我们想一想，下一个最小的、并且靠*2得到的丑数会是什么呢？必然是丑数a的下一个丑数(假设是d)再乘以2.注意，这里的“下一个丑数”指的是，在已有的丑数队列里，紧跟在a后面的那个数。同时，下一个最小的、并且靠*3得到的丑数会是什么呢？依然是b*3。同理下一个最小的、并且靠*5得到的丑数会是什么呢？依然是c*5。所以，对整个队列而言，下一个最小的丑数是什么呢？因为丑数只可能是靠*2，*3，或者*5得到，所以它有三个候选，那就是d*2，b*3，c*5，我们需要从中间挑一个最小的。可见，d是从a往后移动一个位置得到的，而b和c都不变，直接带入了下一轮的竞争。

所以完整的算法描述是：我们维护三个指针idx2,idx3,idx5。当我们想生成队列的下一个最小的丑数时，只需要从nums[idx2]*2,nums[idx3]*3,nums[idx5]*5三个候选之间选一个最小的数m。如果m==nums[idx2]*3，那么我们就将idx2右移；同理如果m==nums[idx3]*3，那么我们就将idx3右移；如果m==nums[idx5]*5，那么我们就将idx5右移。注意，这三种情况可能同时发生。示意图如下。
