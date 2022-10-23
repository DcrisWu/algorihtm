package BinarySearch;

import java.util.Arrays;

/**
 * code_611
 */
public class one_2 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = j + 1, right = n - 1, k = j;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    //寻找满足nums[i] + nums[j] > nums[mid]的最大值，赋给k
                    if (nums[i] + nums[j] > nums[mid]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }
}
