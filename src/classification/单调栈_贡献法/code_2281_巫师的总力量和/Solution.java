package classification.单调栈_贡献法.code_2281_巫师的总力量和;

import java.util.ArrayDeque;
import java.util.Arrays;

// todo 很难
class Solution {
    public int totalStrength(int[] strength) {
        final var mod = (int) 1e9 + 7;

        var n = strength.length;
        var left = new int[n];  // left[i] 为左侧严格小于 strength[i] 的最近元素位置（不存在时为 -1）
        var right = new int[n]; // right[i] 为右侧小于等于 strength[i] 的最近元素位置（不存在时为 n）
        Arrays.fill(right, n);
        var st = new ArrayDeque<Integer>();
        st.push(-1); // 哨兵
        for (var i = 0; i < n; i++) {
            while (st.size() > 1 && strength[st.peek()] >= strength[i])
                right[st.pop()] = i;
            left[i] = st.peek();
            st.push(i);
        }

        var s = 0L; // 前缀和
        var ss = new int[n + 2]; // 前缀和的前缀和
        for (var i = 1; i <= n; ++i) {
            s += strength[i - 1];
            ss[i + 1] = (int) ((ss[i] + s) % mod); // 注意取模后，下面计算两个 ss 相减，结果可能为负
        }

        var ans = 0L;
        for (var i = 0; i < n; ++i) {
            int l = left[i] + 1, r = right[i] - 1; // [l,r] 左闭右闭
            var tot = ((long) (i - l + 1) * (ss[r + 2] - ss[i + 1]) - (long) (r - i + 1) * (ss[i + 1] - ss[l])) % mod;
            ans = (ans + strength[i] * tot) % mod; // 累加贡献
        }
        return (int) (ans + mod) % mod; // 防止算出负数
    }
}
