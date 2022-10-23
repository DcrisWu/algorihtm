package BinarySearch;

import java.util.Arrays;

/**
 * code_1508
 */
public class fourteen_1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(rangeSum(arr, 4, 1, 5));
    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int[] newArr = new int[n * (n + 1) / 2];
        for (int i = 0; i < n; i++) {
            newArr[i] = preSum[i];
        }
        int j = 0, k = j + 1;
        for (int i = n; i < (n * (n + 1) / 2); i++) {
            newArr[i] = preSum[k] - preSum[j];
            k++;
            if (k == n) {
                j++;
                k = j + 1;
            }
        }
        Arrays.sort(newArr);
        int sum = 0;
        for (int i = left-1; i < right; i++) {
            sum = (int) ((sum+newArr[i]) % (1e9 + 7));
        }
        return sum;
    }
}
