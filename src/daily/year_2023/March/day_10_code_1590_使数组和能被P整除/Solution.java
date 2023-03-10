package daily.year_2023.March.day_10_code_1590_使数组和能被P整除;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2023.3.10
 */
class Solution {
    public int minSubarray(int[] nums, int p) {
        int res = 0;
        for (int num : nums) {
            res = (res + num) % p;
        }
        // 如果所有数加起来取模等于0，则不需要删除任何子数组
        if (res == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = nums.length;
        // f(i)表示下标i前所有数组的和的模，不包括nums[i]
        // 要想符合题意，只要找到f(j), (f(j) - f(i) + p) % p == res，去除掉f(i) 到 f(j) 部分，剩下的数组符合题意
        int y = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(y, i);
            y = (y + nums[i]) % p;
            if (map.containsKey((y - res + p) % p)) {
                ans = Math.min(ans, i - map.get((y - res + p) % p) + 1);
            }
        }
        // 不能全删
        return ans == nums.length ? -1 : ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {13, 1, 27, 23, 22, 11, 15, 30, 4, 2, 8, 32, 31, 18, 34, 20, 21};
        System.out.println(solution.minSubarray(arr, 148));
    }
}
