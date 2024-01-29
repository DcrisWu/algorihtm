package ByteDance.code_31_下一个排列;

import java.util.Arrays;

/**
 * completion time = 2023.10.23
 */
class Solution {
    public void nextPermutation(int[] nums) {
        // 从后往前遍历, 对于nums[k]，寻找第一个 < nums[k]的 nums[i]，如果某一次遍历未找到，那么nums[i] >= nums[k]，
        // 令 i = j-1 恒成立
        // 那么在找到所需要的 i 之前，nums[j:end)之间是一个递减序列
        // 在递减序列中，从后往前找到第一个符合nums[i] < nums[k]的 k
        // 交换nums[i]和nums[k]，然后对nums[j:end)进行排序
        int n = nums.length;
        int i = n - 2, j = n - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        if (i < 0) {
            Arrays.sort(nums);
            return;
        }
        int l = j, r = n - 1;
        int k = j;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[i]) {
                k = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
        Arrays.sort(nums, j, n);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        new Solution().nextPermutation(arr);
    }
}