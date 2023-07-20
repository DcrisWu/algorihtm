package classification.回溯.code_216_组合总和III;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.7.20
 */
class Solution {
    private List<List<Integer>> res;
    private int target;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        target = n;
        recursive(new ArrayList<>(), 1, 0, k);
        return res;
    }

    void recursive(List<Integer> have, int now, int preSum, int k) {
        if (have.size() == k) {
            if (preSum == target) {
                res.add(new ArrayList<>(have));
            }
            return;
        }
        for (int i = now; i <= 9; i++) {
            if (preSum + i > target) {
                break;
            }
            have.add(i);
            recursive(have, i + 1, preSum + i, k);
            have.remove(have.size() - 1);
        }
    }
}
