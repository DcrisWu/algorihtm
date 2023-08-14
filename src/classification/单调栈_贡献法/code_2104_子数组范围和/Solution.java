package classification.单调栈_贡献法.code_2104_子数组范围和;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(r, n);
        // 先求最大值，使用递减栈
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        // 左边>, 右边>=
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && nums[stack.peek()] <= nums[i]) {
                r[stack.pop()] = i;
            }
            l[i] = stack.peek();
            stack.push(i);
        }
        long[] max = new long[n];
        for (int i = 0; i < n; i++) {
            max[i] = (long) (i - l[i]) * (r[i] - i);
        }
        stack.clear();
        stack.push(-1);
        Arrays.fill(r, n);
        // 左边<, 右边<=
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && nums[stack.peek()] >= nums[i]) {
                r[stack.pop()] = i;
            }
            l[i] = stack.peek();
            stack.push(i);
        }
        long[] min = new long[n];
        for (int i = 0; i < n; i++) {
            min[i] = (long) (i - l[i]) * (r[i] - i);
        }
        // 算出每个元素作为最大值使用的次数，最小值使用的次数
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += nums[i] * (max[i] - min[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new Solution().subArrayRanges(arr));
    }
}
