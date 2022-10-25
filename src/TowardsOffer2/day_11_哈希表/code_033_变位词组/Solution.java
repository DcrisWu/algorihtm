package TowardsOffer2.day_11_哈希表.code_033_变位词组;

import java.util.*;

/**
 * completion time = 2022.10.23
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new LinkedList<>();
        Map<String, LinkedList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder("");
            for (char aChar : chars) {
                sb.append(aChar);
            }
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new LinkedList<>());
            }
            map.get(sb.toString()).add(str);
        }
        ans.addAll(map.values());
        return ans;
    }
}
