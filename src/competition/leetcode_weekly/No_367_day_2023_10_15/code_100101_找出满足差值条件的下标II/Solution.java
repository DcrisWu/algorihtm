package competition.leetcode_weekly.No_367_day_2023_10_15.code_100101_找出满足差值条件的下标II;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * completion time = 2023.10.15
 */
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        Deque<Integer> min = new ArrayDeque<>(); // 递减
        Deque<Integer> max = new ArrayDeque<>(); // 递增
        for (int i = indexDifference; i < nums.length; i++) {
            while (!min.isEmpty() && nums[i] >= nums[min.peekLast()]) {
                min.pollLast();
            }
            min.addLast(i);
            while (!max.isEmpty() && nums[i] <= nums[max.peekLast()]) {
                max.pollLast();
            }
            max.addLast(i);
        }
        for (int i = 0; i < nums.length - indexDifference; i++) {
            while (!min.isEmpty() && min.peekFirst() - i < indexDifference) {
                min.pollFirst();
            }
            if (Math.abs(nums[i] - nums[min.peekFirst()]) >= valueDifference) {
                return new int[]{i, min.peekFirst()};
            }
            while (!max.isEmpty() && max.peekFirst() - i < indexDifference) {
                max.pollFirst();
            }
            if (Math.abs(nums[i] - nums[max.peekFirst()]) >= valueDifference) {
                return new int[]{i, max.peekFirst()};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {5, 27, 26};
        System.out.println(new Solution().findIndices(arr, 1, 15));
    }
}