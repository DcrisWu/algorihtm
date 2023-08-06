package competition.leetcode_weekly.No_357_day_2023_8_6.code_6925_故障键盘;

/**
 * completion time = 2023.8.6
 */
class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'i'){
                sb.append(s.charAt(i));
            }else {
                sb.reverse();
            }
        }
        return sb.toString();
    }
}
