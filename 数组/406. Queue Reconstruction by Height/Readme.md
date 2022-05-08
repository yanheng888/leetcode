
本题要先对people排序,第一个位置升序，第二个位置降序

Notice:
- 第二个位置降序，因为当高度相同时计算空位置时，如[5,2],[5,0],如果降序则先计算[5,2]位置，再计算[5,0]时，不会受影响，反之则有影响（多计算一个空位置）

reference:https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode-sol/
