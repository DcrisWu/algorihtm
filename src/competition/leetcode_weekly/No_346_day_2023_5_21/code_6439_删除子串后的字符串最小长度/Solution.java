package competition.leetcode_weekly.No_346_day_2023_5_21.code_6439_删除子串后的字符串最小长度;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.5.21
 */
class Solution {
    public int minLength(String s) {
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
            while (stack.size() > 1 &&
                    ((stack.get(stack.size() - 2) == 'A' && stack.get(stack.size() - 1) == 'B') ||
                            (stack.get(stack.size() - 2) == 'C' && stack.get(stack.size() - 1) == 'D'))) {
                stack.remove(stack.size() - 2);
                stack.remove(stack.size() - 1);
            }
        }
        return stack.size();
    }
}
