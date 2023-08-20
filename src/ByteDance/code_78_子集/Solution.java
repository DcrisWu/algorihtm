package ByteDance.code_78_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.8.19
 */
class Solution {
    private int[] nums;
    private List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.ans = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        recursive(part, 0);
        return ans;
    }

    void recursive(List<Integer> bef, int idx) {
        ans.add(new ArrayList<>(bef));
        if (idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            bef.add(nums[i]);
            recursive(bef, i + 1);
            bef.remove(bef.size() - 1);
        }
    }
}
