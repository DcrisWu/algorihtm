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
        int len = nums.length;
        int i = len - 2, j = len - 1, k = len - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        // 不是最大的序列
        if (i >= 0) {
            while (nums[i] >= nums[k]) {
                k--;
            }
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
        // 对nums[j:end)进行排序
        Arrays.sort(nums,j,len);
    }
}