package ByteDance.code_15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2023.8.18
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int t = nums[i] + nums[l] + nums[r];
                if (t == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    ans.add(temp);
                    while (l + 1 < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (r - 1 > l && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (t < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
