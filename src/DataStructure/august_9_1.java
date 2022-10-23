package DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class august_9_1 {
    public static List<String> findRepeatedDnaSequences(String s) {
        int len = 10;
        int n = s.length();
        List<String> ans = new ArrayList<>();
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; n - i >= len; i++) {
            String word = s.substring(i, i + len);
            if (cnt.containsKey(word)) {
                cnt.replace(word, cnt.get(word) + 1);
            } else {
                cnt.putIfAbsent(word, 1);
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : cnt.entrySet()) {
            if(stringIntegerEntry.getValue()>1){
                ans.add(stringIntegerEntry.getKey());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        for (String aaaaacccccaaaaaccccccaaaaagggttt : findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")) {
            System.out.println(aaaaacccccaaaaaccccccaaaaagggttt);
        }
    }
}
