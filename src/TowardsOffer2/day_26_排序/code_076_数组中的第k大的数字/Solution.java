package TowardsOffer2.day_26_排序.code_076_数组中的第k大的数字;

import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        Solution solution = new Solution();
        solution.findKthLargest(arr, 2);
    }
}
