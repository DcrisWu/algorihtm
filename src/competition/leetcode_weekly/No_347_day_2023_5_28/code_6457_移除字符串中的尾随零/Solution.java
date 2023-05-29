package competition.leetcode_weekly.No_347_day_2023_5_28.code_6457_移除字符串中的尾随零;

/**
 * completion time = 2023.5.29
 */
class Solution {
    public String removeTrailingZeros(String num) {
        int tail = num.length();
        while (tail > 1 && num.charAt(tail-1) == '0'){
            tail--;
        }
        return num.substring(0,tail);
    }

}
