package BinarySearch;

import java.util.Arrays;

/**
 * code_1838
 */
public class nine_1 {
    public static void main(String[] args) {
        int[] arr = {1,2,4};
        nine_1 nine_1 = new nine_1();
        System.out.println(nine_1.maxFrequency(arr, 5));
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] before = new int[n];
        for (int i = 1; i < n; i++) {
            before[i] = before[i - 1] + nums[i - 1];
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
//            , cnt = 0
            int left = 0, right = i;
            while (left < right) {
                int mid = (left + right) >> 1;
                int temp = (nums[i] * (i - mid + 1)) - (nums[i] + before[i] - before[mid]);
                if (temp <= k) {
                    max = Math.max(i - mid + 1,max);
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
//            max = Math.max(max, cnt);
        }
        return max;
    }
}
