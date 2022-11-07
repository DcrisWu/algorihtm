package TowardsOffer2.day_28_回溯法.code_084_含有重复元素集合的全排列;

import java.util.*;

/**
 * completion time = 2022.11.7
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> pre = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, pre, 0, nums, used);
        return ans;
    }

    void backTrack(List<List<Integer>> ans, List<Integer> pre, int index, int[] nums, boolean[] used) {
        if (index >= nums.length) {
            ans.add(new ArrayList<>(pre));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            // 标为已经使用
            used[i] = true;
            pre.add(nums[i]);
            backTrack(ans, pre, index + 1, nums, used);
            // 撤回
            used[i] = false;
            pre.remove(index);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 0, 0, 1, 9};
        System.out.println(solution.permuteUnique(arr));
    }
}
