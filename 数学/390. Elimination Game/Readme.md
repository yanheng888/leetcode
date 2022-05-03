
可以通过k判断删除的方向，题目只要求返回a1,所以只用关注a1的变化，而a1只有当删除方向right->left且元素数量为技术才会改变

Notice:
- step_k = 2*step_(k-1)
- only focus on the value of a1
