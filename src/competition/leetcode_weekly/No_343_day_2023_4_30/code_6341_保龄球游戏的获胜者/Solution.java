package competition.leetcode_weekly.No_343_day_2023_4_30.code_6341_保龄球游戏的获胜者;

/**
 * completion time = 2023.4.30
 */
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < player1.length; i++) {
            boolean isDouble = i > 0 && player1[i - 1] == 10;
            if (i > 1 && player1[i - 2] == 10) {
                isDouble = true;
            }
            sum1 += isDouble ? player1[i] * 2 : player1[i];
        }
        for (int i = 0; i < player2.length; i++) {
            boolean isDouble = i > 0 && player2[i - 1] == 10;
            if (i > 1 && player2[i - 2] == 10) {
                isDouble = true;
            }
            sum2 += isDouble ? player2[i] * 2 : player2[i];
        }
        if (sum1 > sum2){
            return 1;
        }else if (sum1 < sum2){
            return 2;
        }else {
            return 0;
        }
    }
}
