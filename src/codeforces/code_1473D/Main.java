package codeforces.code_1473D;

import java.util.*;

/**
 * completion time = 2023.4.12
 * comment:这题还是不是很懂
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            // 字符串长度为n
            int n = scanner.nextInt();
            // 操作m次
            int m = scanner.nextInt();
            String str = scanner.next();
            int[] preSum = new int[n + 1];  // 前缀和
            // prefix[i] 表示 nums[i]之前的和，不包括nums[i]
            int[] prefixMin = new int[n + 1];   // 前缀最小值
            int[] prefixMax = new int[n + 1];   // 前缀最大值
            for (int j = 0; j < n; j++) {
                int num = str.charAt(j) == '+' ? 1 : -1;
                preSum[j + 1] = preSum[j] + num;
                prefixMin[j + 1] = Math.min(prefixMin[j], preSum[j] + num);
                prefixMax[j + 1] = Math.max(prefixMax[j], preSum[j] + num);
            }
            // suffix[i]表示preSum[i]到最后一个元素之间的最小值和最大值，包括nums[i-1]
            int[] suffixMin = new int[n + 1];
            int[] suffixMax = new int[n + 1];
            int postSum = preSum[n];
            suffixMin[n] = postSum;
            suffixMax[n] = postSum;
            for (int j = n - 1; j >= 0; j--) {
                int num = str.charAt(j) == '+' ? -1 : 1;
                postSum += num;
                suffixMin[j] = Math.min(suffixMin[j + 1], postSum);
                suffixMax[j] = Math.max(suffixMax[j + 1], postSum);
            }
            for (int j = 0; j < m; j++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                // 因为中间删除了一段，所以只需要将后半段下降一段距离就可以了，这段距离 = 中间段尾部高度 - 中间段头部高度
                // 然后取两段的最小值和最大值，再相减
                int cha = preSum[r] - preSum[l - 1];
                int min = Math.min(prefixMin[l - 1], suffixMin[r] - cha);
                int max = Math.max(prefixMax[l - 1], suffixMax[r] - cha);
                System.out.println(max - min + 1);
            }
        }
    }
}
