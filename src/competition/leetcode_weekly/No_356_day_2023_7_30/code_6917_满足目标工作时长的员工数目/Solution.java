package competition.leetcode_weekly.No_356_day_2023_7_30.code_6917_满足目标工作时长的员工数目;

/**
 * completion time = 2023.7.30
 */
class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int res = 0;
        for (int hour : hours) {
            if (hour >= target){
                res++;
            }
        }
        return res;
    }
}