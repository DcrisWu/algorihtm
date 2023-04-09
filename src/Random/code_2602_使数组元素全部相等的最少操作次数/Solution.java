package Random.code_2602_使数组元素全部相等的最少操作次数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2023.4.9
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 1, 6, 8};
        int[] queries = {1, 5};
        List<Long> longs = solution.minOperations(arr, queries);
        System.out.println(longs.size());
    }

    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int len = queries.length;
        List<Long> ans = new ArrayList<>(len);
        for (int target : queries) {
            // index表示target前面有index个数
            int index = lowerCase(nums, target);
            long left = (long) target * index - preSum[index];
            long right = preSum[n] - preSum[index] - (long) target * (n - index);
            ans.add(left + right);
        }
        return ans;
    }

    // >= target的第一个index
    int lowerCase(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = nums.length;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
