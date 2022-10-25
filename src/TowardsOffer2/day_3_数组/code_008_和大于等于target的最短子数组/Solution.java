package TowardsOffer2.day_3_数组.code_008_和大于等于target的最短子数组;

/**
 * completion time = 2022.10.17
 */
class Solution {
    //也可以使用前缀和
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int sum = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                r = i;
                len = r - l + 1;
                break;
            }
        }
        while (r < nums.length) {
            while (sum - nums[l] >= target) {
                sum -= nums[l];
                l++;
            }
            len = Math.min(len, r - l + 1);
            if (r + 1 < nums.length) {
                sum += nums[r + 1];
            }
            r = r + 1;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,4,5};
        System.out.println(solution.minSubArrayLen(11, arr));
    }
}
