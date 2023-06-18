package competition.leetcode_weekly.No_350_day_2023_6_18.code_6901_总行驶距离;

class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        for (int i = mainTank; i > 0; ) {
            if (i >= 5) {
                res += 5 * 10;
                i -= 5;
                if (additionalTank > 0) {
                    additionalTank--;
                    i += 1;
                }
            } else {
                res += i * 10;
                i = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.distanceTraveled(9, 2));
    }
}
