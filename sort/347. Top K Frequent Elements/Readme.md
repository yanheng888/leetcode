
Solution: quick select
算出数组的每个数的频率，选出频率第K高的数，然后遍历所有数，如果该数频率>= 第K频率则记录在数组里

注意点：
- quickSelect()递归时，根据i,j,t来区分区间,作为参数不要变量名写错
- quickSelect()各个区间的长度不要计算错误


Solution2: binary search by value
notice:
- count(m)<=k means there are less or equal number of number whose frequency is equal to m

参考链接：https://www.youtube.com/watch?v=6hjV-IdrOd0
