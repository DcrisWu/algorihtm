package BinarySearch;

import Pack.Pair;

import java.util.*;

/**
 * code_981
 */
public class sixteen_1 {

    public static void main(String[] args) {
        sixteen_1 sixteen_1 = new sixteen_1();
        sixteen_1.set("foo", "bar", 1);
        System.out.println(sixteen_1.get("foo", 1));
        System.out.println(sixteen_1.get("foo", 3));
        sixteen_1.set("foo", "bar2", 4);
        System.out.println(sixteen_1.get("foo", 4));
        System.out.println(sixteen_1.get("foo", 5));
    }

    private Map<String, Vector<Pair<Integer, String>>> map;

    public sixteen_1() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        //如果不存在对应键，就先new一个
        if (!map.containsKey(key)) {
            map.putIfAbsent(key, new Vector<>());
        }
        Vector<Pair<Integer, String>> pairs = map.get(key);
        pairs.add(new Pair<>(timestamp,value));
    }

    public String get(String key, int timestamp) {
        //如果不存在对应键，就直接返回“”
        if (!map.containsKey(key)) {
            return "";
        }
        Vector<Pair<Integer, String>> pairs = map.get(key);
        int l = 0, r = pairs.size() - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if(pairs.get(mid).getKey() <= timestamp){
                ans = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return ans == -1 ? "" : pairs.get(ans).getValue();
    }
}
