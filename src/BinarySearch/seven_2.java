package BinarySearch;

import java.util.*;

/**
 * code_1818
 */
public class seven_2 {

    public static void main(String[] args) {
        int[] arr = {1, 21, 28};
        seven_2 seven_2 = new seven_2();
        seven_2.binarySearch(arr, 9);
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int tempDiff = 0;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums1[i];
            tempDiff = (int) ((tempDiff + Math.abs(nums1[i] - nums2[i])) % (1e9 + 7));
        }
        Arrays.sort(temp);
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            int j = binarySearch(temp, nums2[i]);
            if (j < n) {
                maxDiff = Math.max(maxDiff, diff - (temp[j] - nums2[i]));
            }
            if (j > 0) {
                maxDiff = Math.max(maxDiff, diff - (nums2[i] - temp[j - 1]));
            }
        }
        return (int) ((tempDiff + (1e9 + 7) - maxDiff) % (1e9 + 7));
    }

    //寻找rec[]中>target的最小下标
    public int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
