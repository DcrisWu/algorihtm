package competition.leetcode_weekly.No_341_day_2023_4_16.code_6375_构造有效字符串的最少插入数;

/**
 * completion time = 2023.4.16
 */
class Solution {
    public int addMinimum(String word) {
        int count = 0;
        char pre = 'c';
        for (int i = 0; i < word.length(); i++) {
            char want = want(pre);
            count += (word.charAt(i) + 3 - want) % 3;
            pre = word.charAt(i);
        }
        if (pre != 'c') {
            count += 'c' - pre;
        }
        return count;
    }

    char want(char c) {
        int i = (c - 'a' + 1) % 3;
        return (char) ('a' + i);
    }
}