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

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> pre = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(ans, pre, 0, nums,used);
        return ans;
    }

    void backTrack(List<List<Integer>> ans, List<Integer> pre, int index, int[] nums, boolean[] used) {
        if (index >= nums.length) {
            ans.add(new ArrayList<>(pre));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            pre.add(nums[i]);
            backTrack(ans, pre, index + 1, nums, used);
            used[i] = false;
            pre.remove(index);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.permute(arr));
    }
}
