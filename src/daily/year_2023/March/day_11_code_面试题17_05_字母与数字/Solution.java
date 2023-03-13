package daily.year_2023.March.day_11_code_面试题17_05_字母与数字;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2023.3.11
 */
class Solution {
    public String[] findLongestSubarray(String[] array) {
        // map key-下标i前的pre值得和,value-下标i
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int left = 0, right = -1;
        for (int i = 0; i < array.length; i++) {
            map.putIfAbsent(pre, i);
            if (isDigit(array[i])) {
                pre -= 1;
            } else {
                pre += 1;
            }
            if (map.containsKey(pre) && i - map.get(pre) > right - left) {
                left = map.get(pre);
                right = i;
            }
        }
        return Arrays.copyOfRange(array, left, right + 1);
    }

    boolean isDigit(String a) {
        char c = a.charAt(0);
        return Character.isDigit(c);
    }
}