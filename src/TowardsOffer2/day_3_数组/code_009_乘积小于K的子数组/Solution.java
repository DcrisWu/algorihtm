package TowardsOffer2.day_3_数组.code_009_乘积小于K的子数组;

/**
 * completion time = 2022.10.17
 * 本题与713题相同
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        /*int begin = 0;
        int end = -1;
        int ans = 0;
        while (end < nums.length) {
            for (int i = begin; i < nums.length && nums[i] < k; i++) {
                end = i;
            }
            ans += end - begin + 1;

            int product = nums[begin];
            int l = begin, r = begin;
            while (r + 1 <= end) {
                while (r + 1 <= end && product * nums[r + 1] < k) {
                    r = r + 1;
                    product *= nums[r];
                }
                ans += r - l;
                l++;
                r = l;
                product = nums[l];
            }

            end++;
            while (end < nums.length && nums[end] >= k) {
                end++;
            }
            begin = end;
        }
        return ans;*/

        if (k == 0) {
            return 0;
        }
        int product = 1;
        int i = 0, count = 0;
        int n = nums.length;
        //固定右端点j，遍历[i,j]，寻找满足条件的最小i值，j-i+1就是固定了右端点后，符合要求的子数组的数量
        for (int j = 0; j < n; j++) {
            product *= nums[j];
            while (i <= j && product >= k) {
                product /= nums[i];
                i++;
            }
            count += j - i + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10, 100, 10, 5, 2, 6};
        System.out.println(solution.numSubarrayProductLessThanK(arr, 100));
    }
}
