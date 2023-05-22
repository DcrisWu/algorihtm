package competition.leetcode_weekly.No_346_day_2023_5_21.code_6441_求一个整数的惩罚数;

/**
 * completion time = 2023.5.21
 */
class Solution {

    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (isPunish(i)) {
                sum += i * i;
            }
        }
        return sum;
    }

    boolean isPunish(int n) {
        String num = String.valueOf(n * n);
        return backTract(n, 0, num, 0);
    }

    boolean backTract(int target, int pre, String num, int idx) {
        if (idx == num.length() && pre == target) {
            return true;
        }
        for (int i = idx + 1; i <= num.length(); i++) {
            int now = Integer.parseInt(num.substring(idx, i));
            if (pre + now <= target) {
                boolean b = backTract(target, pre + now, num, i);
                if (b) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}


