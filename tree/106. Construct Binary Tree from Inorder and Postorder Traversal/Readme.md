本题有三个Trick:
- Postorder[] 最后一位元素为root
- 找出root后得到该root在inorder的位置pos,则 [low1,pos-1],[pos+1,high1]分别为inorder的递归左子数组和右子数组
- inorder,postorder 左子数组长度相等，同理右子树组相等
