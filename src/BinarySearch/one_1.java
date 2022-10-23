package BinarySearch;

/**
 * code_209
 */
public class one_1 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, arr));
//        System.out.println(findMinLength(3, arr, 0, 5));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int begin = 0;
        int end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                min = Math.min(min, end - begin + 1);
                sum -= nums[begin];
                begin++;
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static int findMinLength(int target, int[] sums, int begin, int end) {
        int mid = (begin + end) / 2;
        if (begin > 0 && sums[end] - sums[begin - 1] < target) {
            return Integer.MAX_VALUE;
        }
        //如果这部分数组包含头部
        if (begin == 0 && sums[end] < target) {
            return Integer.MAX_VALUE;
        }
        return 0;
    }

    public static int findMinLength2(int target, int[] sums, int begin, int end) {

        //如果这个数组的不分和都小于target
        //这部分数组不包含头部
        if (begin > 0 && sums[end] - sums[begin - 1] < target) {
            return Integer.MAX_VALUE;
        }
        //如果这部分数组包含头部
        if (begin == 0 && sums[end] < target) {
            return Integer.MAX_VALUE;
        }
        int len = end - begin + 1;
        if (len == 1) {
            return len;
        }
        int mid = (begin + end) / 2;
        int temp_len = Math.min(findMinLength(target, sums, begin, mid),
                findMinLength(target, sums, mid + 1, end));
        return Math.min(len, temp_len);
    }


}
