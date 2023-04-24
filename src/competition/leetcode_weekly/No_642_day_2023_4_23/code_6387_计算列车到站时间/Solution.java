package competition.leetcode_weekly.No_642_day_2023_4_23.code_6387_计算列车到站时间;

/**
 * completion time = 2023.4.23
 */
class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
