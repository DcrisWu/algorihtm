package competition.leetcode_weekly.No_358_day_2023_8_13.code_7022_限制条件下元素之间的最小绝对差;

import java.util.*;

/**
 * completion time = 2023.8.13
 */
class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = x; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            set.add(nums.get(i));
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size() - x; i++) {
            int num = nums.get(i);
            Integer ceiling = set.ceiling(num);
            Integer floor = set.floor(num);
            int min = Integer.MAX_VALUE;
            if (ceiling != null) {
                min = ceiling - num;
            }
            if (floor != null && num - floor < min) {
                min = num - floor;
            }
            ans = Math.min(min, ans);
            int del = nums.get(i + x);
            if (map.get(del) == 1) {
                set.remove(del);
            } else {
                map.put(del, map.get(del) - 1);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {74, 14, 14};
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        System.out.println(solution.minAbsoluteDifference(list, 1));
    }
}
