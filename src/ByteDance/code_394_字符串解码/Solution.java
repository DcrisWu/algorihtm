package ByteDance.code_394_字符串解码;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * completion time = 2023.8.19
 */
class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // 如果是数字
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int j = i;
                for (; j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9'; j++) ;
                int times = Integer.parseInt(s.substring(i, j));
                Deque<Character> stack = new ArrayDeque<>();
                String sub = "";
                for (int k = j; k < s.length(); k++) {
                    if (!stack.isEmpty() && stack.peek() == '[' && s.charAt(k) == ']') {
                        stack.pop();
                    } else if (s.charAt(k) == '[') {
                        stack.push('[');
                    }
                    if (stack.isEmpty()) {
                        sub = decodeString(s.substring(j + 1, k));
                        j = k;
                        break;
                    }
                }
                i = j;
                for (int k = 0; k < times; k++) {
                    ans.append(sub);
                }
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
    }
}
