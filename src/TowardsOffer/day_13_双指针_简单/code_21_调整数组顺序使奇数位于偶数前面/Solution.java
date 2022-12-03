package TowardsOffer.day_13_双指针_简单.code_21_调整数组顺序使奇数位于偶数前面;

/**
 * completion time = 2022.12.3
 */
class Solution {
    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < nums.length && nums[l] % 2 == 1) {
                l++;
            }
            while (r >= 0 && nums[r] % 2 == 0) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;
    }
}