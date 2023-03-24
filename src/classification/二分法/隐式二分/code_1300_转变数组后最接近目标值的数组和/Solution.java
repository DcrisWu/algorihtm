package classification.二分法.隐式二分.code_1300_转变数组后最接近目标值的数组和;

/**
 * completion time = 2023.3.24
 */
class Solution {

    /**
     * 对于这种在一个范围内取最小值或者最大值的题目，要联想到能不能使用二分
     * 判断能不能使用二分，关键是 pivot 指针左移和右移是否具有唯一的判断条件，
     * 也就是说，true就左移(右移)，false就右移(左移)，满足上述条件，就可以使用二分法求解
     */
    public int findBestValue(int[] arr, int target) {
        int l = 0, r = getMax(arr);
        int ans = 0;
        int preSum = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int sum = getSum(arr, mid);
            if (sum <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            if (preSum == -1) {
                ans = mid;
                preSum = sum;
            } else if (Math.abs(target - sum) < Math.abs(target - preSum)) {
                ans = mid;
                preSum = sum;
            } else if (Math.abs(target - sum) == Math.abs(target - preSum)) {
                ans = Math.min(ans, mid);
            }
        }
        return ans;
    }

    int getMax(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        return max;
    }

    int getSum(int[] arr, int num) {
        int sum = 0;
        for (int i : arr) {
            if (i <= num) {
                sum += i;
            } else {
                sum += num;
            }
        }
        return sum;
    }
}
