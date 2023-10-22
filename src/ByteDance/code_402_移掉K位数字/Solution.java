package ByteDance.code_402_移掉K位数字;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * completion time = 2023.10.22
 */
class Solution {
    // 对于两个相同长度的数字序列，最左边第一个不同的数决定了大小，所以一定要让最小的数字尽量靠前
    // 使用单调栈，在删除k个数字的前提下，保持单调
    public String removeKdigits(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !st.isEmpty() && num.charAt(i) < st.peekLast()) {
                st.pollLast();
                k--;
            }
            st.addLast(num.charAt(i));
        }
        while (k > 0) {
            k--;
            st.pollLast();
        }
        // 前导零需要删除
        while (!st.isEmpty() && st.peekFirst() == '0') {
            st.pollFirst();
        }
        while (!st.isEmpty()) {
            sb.append(st.pollFirst());
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
