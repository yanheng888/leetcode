import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int low = j + 1, high = n - 1,k=j;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (nums[i] + nums[j] <= nums[mid]) {
                        high = mid - 1;
                    } else {
                        k = mid;
                        low = mid+1;
                    }
                }
                res += k-j;
            }
        }
        return res;
    }

    private int help(int num, int num1, int num2) {
        if (num + num1 <= num2) {
            return 0;
        }
        return 1;
    }
}
