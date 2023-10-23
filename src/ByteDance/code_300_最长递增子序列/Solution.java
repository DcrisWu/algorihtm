package ByteDance.code_300_最长递增子序列;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            insert(list, num);
        }
        return list.size();
    }

    void insert(List<Integer> list, int val) {
        int l = 0, r = list.size() - 1;
        int idx = r + 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (list.get(mid) >= val) {
                idx = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (idx == list.size()) {
            list.add(val);
        } else {
            list.set(idx, val);
        }
    }
}
