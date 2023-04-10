package codeforces.code_1201C_Maximum_Median;

import java.util.Arrays;
import java.util.Scanner;

/**
 * completion time = 2023.4.10
 */
// https://codeforces.com/problemset/problem/1201/C
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Main m = new Main();
        System.out.println(m.maximum(nums, k));
    }

    // 这题思路和蓝绿面积是一样的
    public int maximum(int[] nums, int k) {
        Arrays.sort(nums);
        int middle = nums.length / 2;
        long[] preSum = new long[middle + 2];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i + middle - 1];
        }
        int l = middle, r = nums.length - 1;
        int index = 0;
        long leftArea = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            long tmp = (long) nums[mid] * (mid - middle) - preSum[mid - middle];
            if (tmp <= k) {
                index = mid;
                leftArea = tmp;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) (nums[index] + (k - leftArea) / (index - middle + 1));
    }
}
