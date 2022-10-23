package algorithm.day_11.code_17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * completion time = 2022.9.23
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap<>();
        char now = 'a';
        for (char i = '2'; i < '7'; i++) {
            char[] chars = new char[3];
            for (int j = 0; j < 3; j++) {
                chars[j] = now;
                now += 1;
            }
            map.putIfAbsent(i, chars);
        }
        //将7键对应的put进map
        char[] tempChar1 = new char[4];
        for (int i = 0; i < 4; i++) {
            tempChar1[i] = now;
            now += 1;
        }
        map.putIfAbsent('7', tempChar1);
        //将8键对应的put进map
        char[] tempChar2 = new char[3];
        for (int i = 0; i < 3; i++) {
            tempChar2[i] = now;
            now += 1;
        }
        map.putIfAbsent('8', tempChar2);
        //将9键对应的put进map
        char[] tempChar3 = new char[4];
        for (int i = 0; i < 4; i++) {
            tempChar3[i] = now;
            now += 1;
        }
        map.putIfAbsent('9', tempChar3);

        List<String> ans = new LinkedList<>();
        dfs(map, 0, digits.length(), "", digits, ans);
        return ans;
    }

    void dfs(Map<Character, char[]> map, int index, int len, String last, String digits, List<String> ans) {
        if (index >= len) {
            return;
        }
        char key = digits.charAt(index);
        char[] chars = map.get(key);
        for (char aChar : chars) {
            String now = last + aChar;
            if (index == len - 1) {
                ans.add(now);
            }else {
                dfs(map, index + 1, len, now, digits, ans);
            }
        }
    }
}
