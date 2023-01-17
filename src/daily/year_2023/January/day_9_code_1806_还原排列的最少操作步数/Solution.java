package daily.year_2023.January.day_9_code_1806_还原排列的最少操作步数;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reinitializePermutation(6));
    }

    public int reinitializePermutation(int n) {
        int[] arr = new int[n];
        int[] perm;
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int count = 0;
        do {
            perm = Arrays.copyOf(arr, n);
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            count++;
        } while (!check(arr));
        return count;
    }

    boolean check(int[] arr) {
        if (arr[0] != 0) {
            return false;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1] + 1) {
                return false;
            }
        }
        return true;
    }
}
