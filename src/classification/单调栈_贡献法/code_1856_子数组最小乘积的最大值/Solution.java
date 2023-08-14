package classification.单调栈_贡献法.code_1856_子数组最小乘积的最大值;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * completion time = 2023.8.14
 */
class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        // 一边开区间，一边比区间是为了避免重复
        int[] l = new int[n]; // 左边 < nums[i]的最大坐标
        int[] r = new int[n]; // 右边 <= nums[i]的最小坐标
        long[] pre = new long[n + 1];
        int mod = (int) (1e9 + 7);
        Arrays.fill(r, n);
        // 最小值的贡献，单调递增栈
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        // 这种遍历方法一定会存在一个一开一闭
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
            while (stack.size() > 1 && nums[stack.peek()] >= nums[i]) {
                r[stack.pop()] = i;
            }
            l[i] = stack.peek();
            stack.push(i);
        }
        System.out.println(n);
        long ans = 1L;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (pre[r[i]] - pre[l[i] + 1]) * nums[i]);
        }
        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2};
        System.out.println(new Solution().maxSumMinProduct(arr));

    }
}
