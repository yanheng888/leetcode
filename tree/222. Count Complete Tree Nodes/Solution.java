import java.util.ArrayList;

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int h = 0;
        TreeNode node = root;
        while(node != null){
            h += 1;
            node = node.left;
        }
        int low = 1 << (h - 1);
        int high = (1 << h) - 1;
        while(low < high){
            int mid = low + (high - low + 1) / 2;
            if(hasK(root, mid)){
                low = mid;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }

    boolean hasK(TreeNode root, int k)
    {
        ArrayList<Integer> path = new ArrayList<>();
        while(k > 0){
            path.add(k);
            k  >>= 1;
        }
        for(int i = path.size() - 1; i > 0; i--){
            if(root == null){
                return false;
            }
            if(path.get(i) * 2 == path.get(i - 1)){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        if(root == null){
            return false;
        }
        return true;
    }
}
