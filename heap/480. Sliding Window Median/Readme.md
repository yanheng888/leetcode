
注意点：
- map key记录的是要删除的元素,value是要删除的个数
- balance表示的是每一轮循环，因本次窗口滑动导致small堆元素数目与big堆元素个数差值的增量。每次循环balance设置为0
- balance有三种情况0，2，-2

参考链接：https://leetcode-cn.com/problems/sliding-window-median/solution/feng-xian-dui-chong-shuang-dui-dui-ding-hq1dt/
