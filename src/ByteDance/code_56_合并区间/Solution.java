package ByteDance.code_56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        ArrayList<int[]> list = new ArrayList<>();
        int[] temp = {intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (temp[1] >= start) {
                if (temp[1] < end) {
                    temp[1] = end;
                }
            } else {
                list.add(temp);
                temp = new int[]{start, end};
            }
        }
        list.add(temp);
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
}
