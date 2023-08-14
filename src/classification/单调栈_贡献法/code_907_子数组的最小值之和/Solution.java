package classification.单调栈_贡献法.code_907_子数组的最小值之和;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * completion time = 2023.8.14
 *
 * 对于贡献法，有一套用单调栈的模版
 * 如果是找最小值对子数组的贡献，就使用单调递增栈，如果是最大值对子数组的贡献，就使用单调递减栈
 * 注意判断条件的 > 还是 >=
 */
class Solution {
    public int sumSubarrayMins(int[] arr) {
        // 找出arr[i]对子数组的贡献
        int n = arr.length;
        int mod = (int) (1e9 + 7);
        int[] l = new int[n]; // 左边 < arr[i]的最大元素，开区间
        int[] r = new int[n]; // 右边 <= arr[i]的最小下标，开区间
        // 单调递增栈
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        Arrays.fill(r, n);
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && arr[stack.peek()] >= arr[i]) {
                r[stack.pop()] = i;
            }
            l[i] = stack.peek();
            stack.push(i);
        }
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            int tot = (r[i] - i) * (i - l[i]);
            ans = (ans + ((long) arr[i] * tot)) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(new Solution().sumSubarrayMins(arr));
    }
}
