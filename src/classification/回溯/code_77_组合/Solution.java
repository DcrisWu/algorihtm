package classification.回溯.code_77_组合;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.7.20
 */
class Solution {
    private int max;
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        this.res = new ArrayList<>();
        this.max = n;
        recursive(new ArrayList<>(), 1, k);
        return res;
    }

    void recursive(List<Integer> have, int now, int k) {
        if (have.size() == k) {
            res.add(new ArrayList<>(have));
            return;
        }
        for (int i = now; i <= max; i++) {
            if (max - i + 1 < k - have.size()) {
                break;
            }
            have.add(i);
            recursive(have,i+1,k);
            have.remove(have.size() - 1);
        }
    }
}
