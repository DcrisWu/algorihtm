package DataStructure;

import java.util.*;

public class july_7_1 {
    public boolean wordPattern(String pattern, String s) {
        List<String> list = new ArrayList<>();
        int index = 0;

        while (index < s.length()) {
            StringBuilder sb = new StringBuilder("");
            while (index < s.length() && s.charAt(index) != ' ') {
                sb.append(s.charAt(index));
                index++;
            }
            list.add(sb.toString());
            index++;
        }
        if (list.size() != pattern.length()) {
            return false;
        }
        //表示存储26个字母的字典
        String[] dic = new String[26];
        Arrays.fill(dic, " ");
        for (int i = 0; i < pattern.length(); i++) {
            //如果该位置没有映射的字符，就加一个映射的字符
            if (dic[pattern.charAt(i) - 'a'].equals(" ")) {
                dic[pattern.charAt(i) - 'a'] = list.get(i);
            } else if (!dic[pattern.charAt(i) - 'a'].equals(list.get(i))) {
                return false;
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if(dic[i] != " " && !map.containsKey(dic[i])){
                map.putIfAbsent(dic[i],1);
            }else if(map.containsKey(dic[i])){
                return false;
            }

        }
        return true;

    }
}
