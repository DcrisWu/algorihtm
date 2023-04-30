package competition.leetcode_weekly.No_343_day_2023_4_30.code_6344_字典序最小的美丽字符串;

/**
 * completion time = 2023.4.30
 */
class Solution {
    public String smallestBeautifulString(String s, int k) {
        StringBuilder temp = new StringBuilder(s);
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 1; j + s.charAt(i) < 'a' + k; j++) {
                temp.setCharAt(i, (char) (s.charAt(i) + j));
                if (check(temp, i)) {
                    if (construct(temp, s, i + 1, k)) {
                        return temp.toString();
                    }
                }
                temp.setCharAt(i, s.charAt(i));
            }
        }
        return "";
    }

    boolean construct(StringBuilder temp, String s, int idx, int k) {
        for (int i = idx; i < temp.length(); i++) {
            boolean canConstruct = false;
            for (int j = 0; j < k; j++) {
                temp.setCharAt(i, (char) ('a' + j));
                if (check(temp, i)) {
                    canConstruct = true;
                    break;
                }
                temp.setCharAt(i, s.charAt(i));
            }
            if (!canConstruct) {
                return false;
            }
        }
        return true;
    }

    // 只需要判断i之前的是否是回文子串就行了，因为i之后的可以改变，重新调整
    boolean check(StringBuilder s, int i) {
        boolean judge = i <= 0 || s.charAt(i) != s.charAt(i - 1);
        if (i > 1 && s.charAt(i) == s.charAt(i - 2)) {
            judge = false;
        }
        return judge;
    }
}
