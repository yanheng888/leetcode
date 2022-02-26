import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        Queue<LinkedList<Integer>> que = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        temp.add(nums[0]);
        que.add(temp);
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int len = que.size();
            while(len-- > 0){
                LinkedList<Integer> list = que.poll();
                int m = list.size();
                for (int j = 0; j <= m; j++) {
                    list.add(j,num);
                    que.add(new LinkedList<>(list));
                    list.remove(j);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!que.isEmpty()){
            res.add(new ArrayList<>(que.poll()));
        }
        return res;
    }
}
