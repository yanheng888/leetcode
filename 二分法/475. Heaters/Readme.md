https://leetcode-cn.com/problems/heaters/solution/gong-nuan-qi-by-leetcode-solution-rwui/


排序加二分查找。具体而言，对于每个房屋 \textit{house}house，需要在有序数组 \textit{heaters}heaters 中找到最大的下标 ii，使得 \textit{heaters}[i] \le \textit{house}heaters[i]≤house，特别地，当 \textit{heaters}[0] > \textit{house}heaters[0]>house 时，i = -1i=−1。在得到下标 ii 之后，令 j = i + 1j=i+1，则 jj 是满足 \textit{heaters}[j] > \textit{house}heaters[j]>house 的最小下标。特别地，当 \textit{heaters}[n - 1] \le \textit{house}heaters[n−1]≤house 时，j = nj=n，其中 nn 是数组 \textit{heaters}heaters 的长度。

得到下标 ii 和 jj 之后，离房屋 \textit{house}house 最近的供暖器为 \textit{heaters}[i]heaters[i] 或 \textit{heaters}[j]heaters[j]，分别计算这两个供暖器和房屋 \textit{house}house 的距离，其中的最小值即为该房屋需要的供暖器的最小加热半径。对于 i = -1i=−1 或 j = nj=n 的下标越界情况，只要将对应的距离设为 +\infty+∞ 即可
