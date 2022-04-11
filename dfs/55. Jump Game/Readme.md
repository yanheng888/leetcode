本题可以用dfs,也可以用遍历.dfs比较直观，遍历比较难想

Solution: dfs
- i+steps >= nums.length-1 返回 true, 因为能跳的距离已经超过了数组的长度
- maxx <= i+steps 返回 false, 因为此时maxx 不能再向前跳跃

Solution2: 遍历
- 只有当当前遍历的位置在可跳跃的范围内9（i <= rightmost），才更新新的跳跃范围（rightmost),一旦超过数组长度则返回true
- 数组遍历完了还没返回true,则表示无法到达数组最后一位，返回false
