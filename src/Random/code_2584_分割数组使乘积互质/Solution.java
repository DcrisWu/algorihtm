package Random.code_2584_分割数组使乘积互质;

import java.util.*;

/**
 * completion time = 2023.4.18
 */
class Solution {
    /**
     * 首先寻找每个数的质因子出现的下标的范围，对于结果不可以出现在每个质因子 [left,right)，所以结果就是第一个连续段的right
     */
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        // left[i] 表示 质因子 i 首次出现的下标
        Map<Integer, Integer> left = new LinkedHashMap<>();
        // right[i]表示 i 是左端点的情况的右端点的最大值
        int[] right = new int[n];
        Arrays.fill(right, -1);

        // 寻找质因子
        for (int i = 0; i < n; i++) {
            int d = 2;
            int num = nums[i];
            while (d * d <= num) {
                if (num % d == 0) {
                    if (!left.containsKey(d)) {
                        left.put(d, i);
                    } else {
                        right[left.get(d)] = i;
                    }
                    num /= d;
                    while (num % d == 0) {
                        num /= d;
                    }
                }
                d++;
            }
            if (num > 1) {
                if (!left.containsKey(num)) {
                    left.put(num, i);
                } else {
                    right[left.get(num)] = i;
                }
            }
        }
        // 寻找第一个 [left,right) 的right
        int max_r = 0;
        // i 表示 left, right[i]表示 right
        for (int l = 0; l < n; l++) {
            if (l > max_r) {
                return max_r;
            }
            max_r = Math.max(max_r, right[l]);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 8, 15, 3, 5};
        Solution solution = new Solution();
        System.out.println(solution.findValidSplit(arr));
    }
}