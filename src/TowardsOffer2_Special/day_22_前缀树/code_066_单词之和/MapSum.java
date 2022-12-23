package TowardsOffer2_Special.day_22_前缀树.code_066_单词之和;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2022.11.2
 */
class MapSum {

    private Node root;
    Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        Integer before = map.getOrDefault(key, 0);
        map.put(key, val);
        Node now = root;
        for (int i = 0; i < key.length(); i++) {
            if (now.tree[key.charAt(i) - 'a'] == null) {
                now.tree[key.charAt(i) - 'a'] = new Node();
            }
            now.tree[key.charAt(i) - 'a'].sum += val - before;
            now = now.tree[key.charAt(i) - 'a'];
        }
    }

    public int sum(String prefix) {
        Node now = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (now.tree[prefix.charAt(i) - 'a'] == null) {
                return 0;
            }
            now = now.tree[prefix.charAt(i) - 'a'];
        }
        return now.sum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("apple"));
        mapSum.insert("ap", 2);
        mapSum.insert("apple", 2);
        System.out.println(mapSum.sum("ap"));
    }
}

class Node {
    int sum = 0;
    Node[] tree = new Node[26];
}
