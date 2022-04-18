class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int res = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentSq = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentSq += 1;

                }


                res = Math.max(res, currentSq);
            }
        }

        return res;
    }
}
