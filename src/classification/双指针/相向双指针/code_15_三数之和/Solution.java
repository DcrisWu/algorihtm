package classification.双指针.相向双指针.code_15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 首先确定三元组的第一个数字
        for (int i = 0; i < nums.length - 2; i++) {
            // 因为数组是单调的，如果第一个都 > 0，就不可能符合题意
            if (nums[i] > 0) {
                break;
            }
            // 因为答案不可以重复，所以遇到相同的数，就直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 第2和第3个数字从 i+1 , nums.length-1开始
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    // 当已经找到一个三元组时候，我们要排除重复的三元组
                    // 做法就是，当left遇到跟前一个相同的元素，就跳过；当right遇到一个跟后面相同的元素，也跳过
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                    // 如果 < 0，那就left右移
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    // 如果 > 0，那就right左移
                    right--;
                }
            }
        }
        return ans;
    }
}
