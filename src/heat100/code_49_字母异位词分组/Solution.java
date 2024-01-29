package heat100.code_49_字母异位词分组;

import java.util.*;

/**
 * completion time = 2024.1.21
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String s = Arrays.toString(array);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(i);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<Integer> list : map.values()) {
            List<String> temp = new ArrayList<>();
            for (Integer idx : list) {
                temp.add(strs[idx]);
            }
            res.add(temp);
        }
        return res;

    }
}