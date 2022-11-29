package daily.year_2022.July;

import java.util.HashMap;
import java.util.LinkedList;

import static java.lang.Math.max;

public class july_9 {
    public static int lenLongestFibSubseq(int[] arr) {
        int len = 0;
        LinkedList<Integer> ans = new LinkedList<>();
        //键存的是数组的值，值存的是数组的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[j][i] = max(dp[k][j]+1, 3);
                }
                len = max(len, dp[j][i]);
            }

        }
        return len;

    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 7, 8, 11, 13, 14, 15, 21, 22, 34};
        System.out.println(lenLongestFibSubseq(arr));
    }
}
