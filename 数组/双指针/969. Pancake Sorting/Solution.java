class Solution {
public:
    int find_pos(vector<int>& arr, int x) {
        for(int i = 0; i < arr.size(); i++) if(arr[i] == x) return i + 1;
        return 0;
    }
    vector<int> pancakeSort(vector<int>& arr) {
        int n = arr.size() + 1;
        vector<int> ans;
        while(--n) {
            int k = find_pos(arr, n);
            if(k == n) continue;
            else {
                ans.push_back(k);
                reverse(arr.begin(), arr.begin() + k);
                ans.push_back(n);
                reverse(arr.begin(), arr.begin() + n);
            }
        }
        return ans;
    }
};
