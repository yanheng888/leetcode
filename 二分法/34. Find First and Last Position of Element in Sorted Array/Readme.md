
因为数组是有重复元素，可能出现这样的情况[....,6,6,6,6,6,6,6,6,....] target = 6
所以如果求两个小标，需要用两个while循环来确定左标和右标

第一个while确定左标，当nums[mid] == target, high = mid-1, 其它的和普通二分一样.

第二个while确定右标，当nums[mid] == target, low = mid+1, 其它的和普通二分一样

while结束后还要确定元素是不是在数组中
