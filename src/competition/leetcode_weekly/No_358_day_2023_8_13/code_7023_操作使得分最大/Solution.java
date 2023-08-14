package competition.leetcode_weekly.No_358_day_2023_8_13.code_7023_操作使得分最大;

import java.util.*;

/**
 * completion time = 2023.8.13
 */
class Solution {

    private int mx = (int) (1e5 + 1);
    private int[] omega;
    private int mod = (int) (1e9 + 7);

    void init() {
        for (int i = 2; i < mx; i++) {
            // 如果是质数
            if (omega[i] == 0) {
                for (int j = i; j < mx; j += i) {
                    omega[j]++;
                }
            }
        }
    }

    // 贡献法
    public int maximumScore(List<Integer> nums, int k) {
        omega = new int[mx];
        init();
        int n = nums.size();
        // 算出当前元素的贡献
        int[] l = new int[n];// 左边 >= nums[i]的最大下标，不包括l[i]
        int[] r = new int[n];// 右边 > nums[i]的最小坐标，不包括r[i]
        Arrays.fill(r, n);
        // 单调递减栈
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && omega[nums.get(stack.peek())] < omega[nums.get(i)]) {
                r[stack.pop()] = i;
            }
            // 弹出后的栈顶 >= nums[i]
            l[i] = stack.peek();
            stack.push(i);
        }
        var ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        // 根据元素大小降序排列
        Arrays.sort(ids, (i, j) -> nums.get(j) - nums.get(i));
        long ans = 1L;
        for (Integer i : ids) {
            int num = nums.get(i);
            int tot = (i - l[i]) * (r[i] - i);
            if (k <= tot) {
                ans = ans * pow(num, k) % mod;
                break;
            }
            ans = ans * pow(num, tot) % mod;
            k -= tot;
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