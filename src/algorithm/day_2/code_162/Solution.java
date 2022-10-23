package algorithm.day_2.code_162;

/**
 * completion time = 2022.9.15
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2};
        System.out.println(solution.findPeakElement(arr));
    }
    public int findPeakElement(int[] nums) {
        int n = nums.length, l = 0, r = n - 1,ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int left = mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int right = mid + 1 > n - 1 ? Integer.MIN_VALUE : nums[mid + 1];
            if (nums[mid] >= left && nums[mid] >= right) {
                ans = mid;
                break;
            }
            if (nums[mid] < right) {
                l = mid + 1;
            } else if (nums[mid] < left) {
                r = mid - 1;
            }
        }
        return ans;
    }
}
