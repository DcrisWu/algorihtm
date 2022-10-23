package DataStructure;

import java.util.*;

public class july_8_1 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        String[] temp = new String[n];
        for (int i = 0; i < n; i++) {
            String s = strs[i];
            char[] ch = new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                ch[j] = s.charAt(j);
            }
            Arrays.sort(ch);
            StringBuilder sb = new StringBuilder("");
            for (char c : ch) {
                sb.append(c);
            }
            temp[i] = sb.toString();
        }
        for (String s : temp) {
            System.out.println(s);
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            //遇到新的字符串，就new一个lList
            map.putIfAbsent(temp[i],new LinkedList<>());
            //往已经存在的字符串哈希表里，添加当前单词的下标
            map.get(temp[i]).add(i);
        }
        List<List<String>> ans = new ArrayList<>();
        for (String s : map.keySet()) {
            List<String> part_ans = new ArrayList<>();
            for (Integer integer : map.get(s)) {
                part_ans.add(strs[integer]);
            }
            ans.add(part_ans);
        }
        return ans;

    }
}
