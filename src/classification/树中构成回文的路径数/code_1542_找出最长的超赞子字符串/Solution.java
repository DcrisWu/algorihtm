package classification.树中构成回文的路径数.code_1542_找出最长的超赞子字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于回文字符串，但不要求顺序的，可以考虑用XOR操作
 */
class Solution {
    public int longestAwesome(String s) {
        int num = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < s.length(); i++) {
            num = num ^ (1 << (s.charAt(i) - '0'));
            // 如果之前出现过，说明中间排序后形成了一个回文字符串
            if (map.containsKey(num)) {
                ans = Math.max(ans, i - map.get(num));
            }
            for (int j = 0; j < 10; j++) {
                if (map.containsKey((1 << j) ^ num)) {
                    ans = Math.max(ans, i - map.get((1 << j) ^ num));
                }
            }
            map.putIfAbsent(num, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestAwesome("3242415"));
    }
}
