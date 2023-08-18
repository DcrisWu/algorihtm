package ByteDance.code_300_最长递增子序列;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            insert(list, nums[i]);
        }
        return list.size();
    }

    void insert(List<Integer> list, int num) {
        int l = 0, r = list.size() - 1;
        int ans = list.size();
        // 找到第一个 >= num的数
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (list.get(mid) >= num) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (ans == list.size()) {
            list.add(num);
        } else {
            list.set(ans, num);
        }
    }
}
