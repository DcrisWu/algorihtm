package TowardsOffer2_Special.day_28_回溯法.code_083_没有重复元素集合的全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2022.11.7
 */
class Solution {
    /*public List<List<Integer>> permute(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, output, 0);
        return ans;
    }

    void backTrack(List<List<Integer>> ans, List<Integer> output, int first) {
        if (first >= output.size()) {
            ans.add(new ArrayList<>(output));
        } else {
            for (int i = first; i < output.size(); i++) {
                // 交换两个元素
                Collections.swap(output, first, i);
                backTrack(ans, output, first + 1);
                // 撤销交换
                Collections.swap(output, first, i);
            }
        }
    }*/

    private List<List<Integer>> res;
    private boolean[] visit;
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
        visit = new boolean[nums.length];
        dfs(new ArrayList<>());
        return res;
    }

    void dfs(List<Integer> pre) {
        if (pre.size() == visit.length) {
            res.add(new ArrayList<>(pre));
        }
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                pre.add(nums[i]);
                visit[i] = true;
                dfs(pre);
                visit[i] = false;
                pre.remove(pre.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.permute(arr));
    }
}
