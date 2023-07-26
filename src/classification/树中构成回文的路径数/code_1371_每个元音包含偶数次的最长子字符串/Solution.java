package classification.树中构成回文的路径数.code_1371_每个元音包含偶数次的最长子字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于回文字符串，但不要求顺序的，可以考虑用XOR操作
 */
class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> offset = new HashMap<>();
        offset.put('a', 0);
        offset.put('e', 1);
        offset.put('i', 2);
        offset.put('o', 3);
        offset.put('u', 4);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (offset.containsKey(s.charAt(i))) {
                num ^= 1 << offset.get(s.charAt(i));
            }
            // 因为这里只能是偶数个元音字母，所以只需要判断 XOR 之后是否为0，也就是是否存在过相等的数就可以了
            if (map.containsKey(num)) {
                ans = Math.max(ans, i - map.get(num));
            }
            map.putIfAbsent(num, i);
        }
        return ans;
    }
}