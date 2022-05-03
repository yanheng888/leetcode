
This problem includes many detail, if we use while(l1!=null && l2!=null),we may need to consider many edge case. However, if we use (l1!= null && l2 != null && carry !=0), will avoid many edge case

Notice:
- two list length may not be same. when both list reach the end, the loop end. 
- be care about carry. The loop should not be terminated if carry != 0


reference:https://leetcode-cn.com/problems/sum-lists-lcci/solution/lian-biao-qiu-he-by-leetcode-solution-vcyz/
