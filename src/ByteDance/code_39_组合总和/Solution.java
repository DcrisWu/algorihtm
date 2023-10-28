package ByteDance.code_39_组合总和;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.10.28
 */
class Solution {
    private List<List<Integer>> res;
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        recursive(0, 0, new ArrayList<>());
        return res;
    }

    void recursive(int idx, int preSum, List<Integer> pre) {
        if (preSum == target) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (preSum + candidates[i] <= target) {
                pre.add(candidates[i]);
                recursive(i, preSum + candidates[i], pre);
                pre.remove(pre.size() - 1);
            }
        }
    }
}
