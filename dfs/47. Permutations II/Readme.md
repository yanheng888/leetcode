**Solution: 插板法**

Notice:
- idx is the pos to insert and nums[i] is the element we try to use to insert
- res.add(new list) since we will pop from list after recursion which will result in deleting from res. New list will prevent this situation
- to avoid duplicates in res, **first sort the nums. Then (i > 0 && nums[i] == nums[i - 1] && memo[i - 1])**

**Solution2: brute force**

Notice:
- use hashset to prevent duplicate
- Arraylist is faster than linkedlist when insert or remove from the end of list

reference:https://leetcode-cn.com/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/
