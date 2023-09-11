package competition.leetcode_weekly.No_362_day_2023_9_10.code_8029_与车相交的点;

import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2023.9.10
 */
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] d = new boolean[101];
        for (List<Integer> num : nums) {
            int start = num.get(0);
            int end = num.get(1);
            Arrays.fill(d, start, end+1, true);
        }
        int count = 0;
        for (boolean b : d) {
            if (b){
                count++;
            }
        }
        return count;
    }
}