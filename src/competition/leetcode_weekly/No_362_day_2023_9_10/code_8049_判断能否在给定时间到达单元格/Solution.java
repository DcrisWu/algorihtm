package competition.leetcode_weekly.No_362_day_2023_9_10.code_8049_判断能否在给定时间到达单元格;

/**
 * completion time = 2023.9.10
 */
class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy){
            return t != 1;
        }
        // 最短时间内，最多能够走斜角的次数
        int absx = Math.abs(fx - sx);
        int absy = Math.abs(fy - sy);
        int small = Math.min(absx, absy);
        int min = absx + absy - small;
        return t >= min;
    }
}