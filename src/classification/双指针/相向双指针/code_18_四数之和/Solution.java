package classification.双指针.相向双指针.code_18_四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2023.3.21
 */
class Solution {
    /**
     * 思路是：排序 + 双指针
     * 和三数求和思路类似，但要注意的是，四个数相加可能会 > int的范围，需要强转为 long
     * 时间复杂度为O(n^3)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = nums.length - 1; j > i; j--) {
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int left = i + 1, right = j - 1;
                while (left < right) {
                    long num = (long) nums[i] + (long) nums[left] + (long) nums[right] + (long) nums[j];
                    if (num == (long)target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        temp.add(nums[j]);
                        ans.add(temp);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (num < (long)target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}