package competition.leetcode_weekly.No_342_day_2023_4_23.code_6390_滑动子数组的美丽值;

/**
 * completion time = 2023.4.23
 */
class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // cnt[i]表示 i 出现过的次数，因为nums[i]的取值范围是[-50,50]，取值范围很小，可以直接枚举
        int[] cnt = new int[101];
        int base = 50;
        for (int i = 0; i < k - 1; i++) {
            cnt[nums[i] + base]++;
        }
        for (int i = 0; i < ans.length; i++) {
            cnt[nums[i + k - 1] + base]++;
            int sum = 0;
            for (int j = 0; j < cnt.length; j++) {
                sum += cnt[j];
                if (sum >= x) {
                    ans[i] = Math.min(j - base, 0);
                    break;
                }
            }
            cnt[nums[i] + base]--;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5};
        Solution solution = new Solution();
        int[] beauty = solution.getSubarrayBeauty(nums, 2, 2);
        System.out.println(beauty);
    }
}
