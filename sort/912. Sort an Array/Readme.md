
Solution1: bubble sort

Solution2: qucik sort

Solution3: merge sort


在quick sort中，可以先写出以right为pivot index的算法，然后在这个基础上加上randomizedQuickSort, 就可以实现以随机数为pivot index的quick sort

在merge sort中：

- mergeSort(int[] nums, int left int right)为主要方法，里面调用merge(int[] nums, int left, int mid, int right):
```
        int mid = left+(right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
```

- merge()中，复制左右两个子数组时注意计算下标，nums下标需要加上offset,遍历左数组，offset为left,遍历有数组时，offset为mid+1
```
        for (int i = 0; i < n1; i++) {
            leftArr[i] = nums[i+left];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = nums[i+mid+1];
        }
```

- merge()中，有三个指针,i,j,k分别指向左数组，右数组，nums,其中初始值i = 0, j = 0,k = left
