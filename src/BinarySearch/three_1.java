package BinarySearch;

import java.util.Arrays;

/**
 * code_300
 */
public class three_1 {
    public int lengthOfLIS(int[] nums) {
        /*int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int max = 1;
        for (int i = 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    ans[i] = Math.max(ans[i], ans[j] + 1);
                    max = Math.max(max, ans[i]);
                }
            }
        }
        return max;*/
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        three_1 three_1 = new three_1();
        int[] arr = {0,8,4,12,2};
        System.out.println(three_1.lengthOfLIS(arr));
    }
}
