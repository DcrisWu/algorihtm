package BasicCoding.day_17.code_860;

/**
 * completion time = 2022.10.11
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 0 表示5元的张数，1 表示 15元的张数
        int[] have = new int[2];
        for (int bill : bills) {
            if (bill == 5) {
                have[0] += 1;
            } else {
                if (bill == 10) {
                    if (have[0] == 0) {
                        return false;
                    } else {
                        have[0]--;
                        have[1]++;
                    }
                } else {
                    if (have[1] > 0 && have[0] > 0) {
                        have[1]--;
                        have[0]--;
                    } else if (have[0] > 2) {
                        have[0] -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
