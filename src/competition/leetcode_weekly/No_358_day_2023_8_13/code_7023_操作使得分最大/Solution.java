package competition.leetcode_weekly.No_358_day_2023_8_13.code_7023_操作使得分最大;

import java.util.*;

/**
 * completion time = 2023.8.13
 */
class Solution {
    private static int mod = (int) (1e9 + 7);
    private static int mx = (int) (1e5 + 1);
    private static int[] omega = new int[mx];

    static {
        // 2,4,6,8,...都加一，然后omega[i] != 0，所以这些不是质数
        for (int i = 2; i < mx; i++) {
            if (omega[i] == 0) {
                for (int j = i; j < mx; j += i) {
                    omega[j]++;
                }
            }
        }
    }

    // 贡献法
    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] l = new int[n];// 左边 >= omega[i]的最大下标
        int[] r = new int[n];// 右边 > omega[i]的最小下标
        Arrays.fill(r, n);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && omega[nums.get(stack.peek())] < omega[nums.get(i)])
                r[stack.pop()] = i;
            l[i] = stack.peek();
            stack.push(i);
        }
        var ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> nums.get(j) - nums.get(i));
        long ans = 1L;
        for (int i : ids) {
            long tot = (long) (i - l[i]) * (r[i] - i);
            if (tot >= k) {
                ans = ans * pow(nums.get(i), k) % mod;
                break;
            }
            ans = ans * pow(nums.get(i), (int) tot) % mod;
            k -= tot; // 更新剩余操作次数
        }
        return (int) ans;
    }

    long pow(long x, int n) {
        long res = 1L;
        for (; n > 0; n = n >> 1) {
            if (n % 2 != 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 9, 3, 8};
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        System.out.println(new Solution().maximumScore(list, 2));
    }
}