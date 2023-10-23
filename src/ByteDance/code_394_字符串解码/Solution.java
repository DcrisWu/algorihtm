package ByteDance.code_394_字符串解码;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * completion time = 2023.8.19
 */
class Solution {
    // 递归解析 2[c] 格式
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                int times = Integer.parseInt(s.substring(i, j));
                // 这个栈是用来记录 []
                Deque<Character> st = new ArrayDeque<>();
                for (int k = j; k < s.length(); k++) {
                    if (s.charAt(k) == '[') {
                        st.addLast('[');
                    } else if (!st.isEmpty() && st.peekFirst() == '[' && s.charAt(k) == ']') {
                        st.pollLast();
                    }
                    // 找到了一个子序列，就是[]内的序列
                    if (st.isEmpty()) {
                        String sub = decodeString(s.substring(j + 1, k));
                        ans.append(sub.repeat(times));
                        i = k;
                        break;
                    }
                }
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a2[c]]"));
    }
}
