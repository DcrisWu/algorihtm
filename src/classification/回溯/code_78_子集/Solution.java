package classification.回溯.code_78_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.9.8
 */
class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        recursive(new ArrayList<>(), nums, 0);
        return res;
    }

    void recursive(List<Integer> pre, int[] nums, int idx) {
        res.add(new ArrayList<>(pre));
        for (int i = idx; i < nums.length; i++) {
            pre.add(nums[i]);
            recursive(pre, nums, i + 1);
            pre.remove(pre.size() - 1);
        }
    }
}