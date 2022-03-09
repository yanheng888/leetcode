
**Solution1 : quick sort**

**Solution2 : heap sort**
sort()+heapify()

heapify(int[] nums, int n, int i): 这里的n是表示数组还未排序的元素数量，在sort()里通过反向遍历，n不断减小，因为每遍历一次，未排序的元素数量-1

**Solution3 : merge sort**

merge()+partition(), 先partition,然后merge
