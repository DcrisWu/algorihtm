package DataStructure;

import java.util.HashMap;
import java.util.Map;

public class july_6_2 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //如果已经存在这个键，就加一
            if (temp.containsKey(s.charAt(i))) {
                temp.put(s.charAt(i), temp.get(s.charAt(i)) + 1);
            }
            //否则插入
            temp.putIfAbsent(s.charAt(i), 1);
        }
        int ans = 0;
        Boolean odd = false;
        for (Character key : temp.keySet()) {
            //如果是偶数
            if (temp.get(key) % 2 == 0) {
                ans += temp.get(key);
            } else {
                //如果是奇数
                odd = true;
                ans += temp.get(key) / 2 * 2;
            }
        }
        if (odd) {
            ans += 1;
        }
        return ans;

    }
}
