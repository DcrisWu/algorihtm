package BinarySearch;

/**
 * code_1283
 */
public class five_2 {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = (int) 1e6, n = nums.length,ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += (nums[i] - 1) / mid + 1;
            }
            //当cnt足够小的时候，说明mid够大了，可以缩小范围
            if (cnt <= threshold) {
                right = mid - 1;
                ans = mid;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

