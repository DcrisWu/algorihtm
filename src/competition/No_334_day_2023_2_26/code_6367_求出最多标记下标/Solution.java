package competition.No_334_day_2023_2_26.code_6367_求出最多标记下标;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 78, 27, 48, 14, 86, 79, 68, 77, 20, 57, 21, 18, 67, 5, 51, 70, 85, 47, 56, 22, 79, 41, 8, 39, 81, 59, 74, 14, 45, 49, 15, 10, 28, 16, 77, 22, 65, 8, 36, 79, 94, 44, 80, 72, 8, 96, 78, 39, 92, 69, 55, 9, 44, 26, 76, 40, 77, 16, 69, 40, 64, 12, 48, 66, 7, 59, 10};
        System.out.println(solution.maxNumOfMarkedIndices(arr));
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        boolean[] mark = new boolean[nums.length];
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            if (search(i, nums, nums.length / 2, nums.length - 1, mark)) {
                count += 2;
            }
        }
        return count;
    }

    boolean search(int begin, int[] nums, int left, int right, boolean[] mark) {
        if (mark[begin]) {
            return false;
        }
        int l = left, r = right;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[begin] * 2 <= nums[mid] && !mark[mid]) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (ans != -1) {
            mark[begin] = true;
            mark[ans] = true;
            return true;
        } else {
            return false;
        }
    }
}