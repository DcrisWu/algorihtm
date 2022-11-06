package TowardsOffer2.day_27_回溯法.code_080_含有k个元素的组合;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        dfs(n, 1, k, 0, ans, init);
        return ans;
    }

    public void dfs(int n, int index, int k, int have, List<List<Integer>> ans, List<Integer> pre) {
        for (int i = index; i <= n; i++) {
            List<Integer> now = new ArrayList<>(pre);
            now.add(i);
            int nowHave = have + 1;
            if (nowHave == k) {
                ans.add(now);
            }
            dfs(n, i + 1, k, nowHave, ans, now);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(4, 3);
        System.out.println(combine);
    }
}
