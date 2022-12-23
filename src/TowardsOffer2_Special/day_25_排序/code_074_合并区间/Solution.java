package TowardsOffer2_Special.day_25_排序.code_074_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * completion time = 2022.11.5
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        int begin = 0;
        while (begin < intervals.length) {
            int end = begin;
            int last = intervals[end][1];
            while (end < intervals.length - 1 && last >= intervals[end + 1][0]) {
                last = Math.max(last, intervals[end + 1][1]);
                end++;
            }
            int[] part = {intervals[begin][0], last};
            ans.add(part);
            begin = end + 1;
        }
//        if (begin < intervals.length) {
//            ans.add(intervals[intervals.length - 1]);
//        }
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        int[][] arr = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        Solution solution = new Solution();
        System.out.println(solution.merge(arr));
    }
}
