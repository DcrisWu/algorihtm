package daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class july_14 {
    Trie trie;
    String weightKey;

    public july_14(String[] words) {
        trie = new Trie();
        weightKey = "##";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie cur = trie;
            int m = word.length();
            for (int j = 0; j < m; j++) {
                Trie tmp = cur;
                for (int k = j; k < m; k++) {
                    String key = new StringBuilder().append(word.charAt(k)).append('#').toString();
                    if (!tmp.children.containsKey(key)) {
                        tmp.children.put(key, new Trie());
                    }
                    tmp = tmp.children.get(key);
                    tmp.weight.put(weightKey, i);
                }
                tmp = cur;
                for (int k = j; k < m; k++) {
                    String key = new StringBuilder().append('#').append(word.charAt(m - k - 1)).toString();
                    if (!tmp.children.containsKey(key)) {
                        tmp.children.put(key, new Trie());
                    }
                    tmp = tmp.children.get(key);
                    tmp.weight.put(weightKey, i);
                }
                String key = new StringBuilder().append(word.charAt(j)).append(word.charAt(m - j - 1)).toString();
                if (!cur.children.containsKey(key)) {
                    cur.children.put(key, new Trie());
                }
                cur = cur.children.get(key);
                cur.weight.put(weightKey, i);
            }
        }
    }

    public int f(String pref, String suff) {
        Trie cur = trie;
        int m = Math.max(pref.length(), suff.length());
        for (int i = 0; i < m; i++) {
            char c1 = i < pref.length() ? pref.charAt(i) : '#';
            char c2 = i < suff.length() ? suff.charAt(suff.length() - 1 - i) : '#';
            String key = new StringBuilder().append(c1).append(c2).toString();
            if (!cur.children.containsKey(key)) {
                return -1;
            }
            cur = cur.children.get(key);
        }
        return cur.weight.get(weightKey);
    }


    public static void main(String[] args) {
        String[] arr = {"apple"};
        july_14 july_14 = new july_14(arr);
        System.out.println(july_14.f("a", "e"));
        String s = "apple";
        System.out.println(s.length() - 1);
        System.out.println(s.length());
        System.out.println(s.substring(0, 1));
        System.out.println(s.substring(4, 5));
    }
}

class Trie {
    Map<String, Trie> children;
    Map<String, Integer> weight;

    public Trie() {
        children = new HashMap<String, Trie>();
        weight = new HashMap<String, Integer>();
    }

}