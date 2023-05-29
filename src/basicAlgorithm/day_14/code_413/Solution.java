package basicAlgorithm.day_14.code_413;

import java.util.Arrays;

/**
 * completion time = 2022.9.25
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(solution.numberOfArithmeticSlices2(arr));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int count = 0;
        int len = nums.length;
        int[][] state = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(state[i], -1);
        }
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] + nums[i + 2] == nums[i + 1] * 2) {
                state[i][i + 2] = nums[i + 1] - nums[i];
                count++;
            }
        }
        for (int r = 3; r < len; r++) {
            for (int l = r - 3; l >= 0; l--) {
                if (state[l + 1][r] != -1 && nums[l + 1] - nums[l] == state[l + 1][r]) {
                    state[l][r] = state[l + 1][r];
                    count++;
                }
            }
        }
        return count;
    }

    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }
}
