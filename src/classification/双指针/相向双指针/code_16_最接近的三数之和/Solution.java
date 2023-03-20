package classification.双指针.相向双指针.code_16_最接近的三数之和;

import java.util.Arrays;

/**
 * completion time  = 2023.3.20
 */
class Solution {
    /**
     * 这道题跟三数之和很类似
     * 先选择一个数固定后，然后该下标后的数组作为一个子数组，用双指针遍历
     * 根据Math.abs(三元组的值 - target)与 Math.abs(ans-target)来比较，选择最小的那个为ans
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] <= target) {
                    if (ans == Integer.MAX_VALUE) {
                        ans = nums[left] + nums[right] + nums[i];
                    } else {
                        if (Math.abs(target - (nums[i] + nums[left] + nums[right])) < Math.abs(target - ans)) {
                            ans = nums[left] + nums[right] + nums[i];
                        }
                    }
                    left++;
                } else {
                    if (ans == Integer.MAX_VALUE) {
                        ans = nums[left] + nums[right] + nums[i];
                    } else {
                        if (Math.abs(target - (nums[i] + nums[left] + nums[right])) < Math.abs(target - ans)) {
                            ans = nums[left] + nums[right] + nums[i];
                        }
                    }
                    right--;
                }
            }
        }
        return ans;
    }
}