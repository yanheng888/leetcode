class Solution {
    public boolean isAdditiveNumber(String num) {
        return dfs(num,0,0,0,0);
    }

    private boolean dfs(String num, int index, int cnt, long pre, long prepre) {
        if(index >= num.length()){
            return cnt>2;
        }
        long current = 0;
        for (int i = index; i < num.length(); i++) {
            if(num.charAt(index) == '0' && i>index){
                // 剪枝1：不能做为前导0，但是它自己是可以单独做为0来使用的
                return false;
            }
            char c = num.charAt(i);
            current = current*10 + c-'0';
            if(cnt>=2){
                long sum = pre+prepre;
                if(current > sum){
                    // 剪枝2：如果当前数比之前两数的和大了，说明不合适
                    return false;
                }else if (current < sum){
                    // 剪枝3：如果当前数比之前两数的和小了，说明还不够，可以继续添加新的字符进来
                    continue;
                }else{
                    // 当前满足条件了，向下一层探索
                    if(dfs(num,i+1,cnt+1,current,pre)){
                        return true;
                    }
                }
            }else{
                //还不到两个数，向下一层探索
                if(dfs(num,i+1,cnt+1,current,pre)){
                    return true;
                }
            }

        }
        return false;
    }
}
