package TowardsOffer2.day_39.code_114_外星文字典;

import java.util.*;

/**
 * completion time = 2022.11.17
 */
class Solution {

    private final int VISITED = 1, VISITING = 2;
    private Map<Character, Integer> states = new HashMap<>();
    private Map<Character, List<Character>> edges = new HashMap<>();
    boolean valid = true;
    char[] order;
    int index;

    public String alienOrder(String[] words) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                edges.putIfAbsent(word.charAt(i), new ArrayList<>());
            }
        }
        order = new char[edges.size()];
        index = edges.size() - 1;
        for (int i = 1; i < words.length; i++) {
            addEdges(words[i - 1], words[i]);
        }
        // 如果排序不符合要求，直接返回""
        if (!valid) {
            return "";
        }
        for (Character character : edges.keySet()) {
            if (!states.containsKey(character)){
                dfs(character);
            }
        }
        if (!valid){
            return "";
        }
        return new String(order);
    }

    void addEdges(String before, String next) {
        int len = Math.min(before.length(), next.length());
        int i = 0;
        // 首个不同的字母，表示相对顺序
        while (i < len) {
            if (before.charAt(i) != next.charAt(i)) {
                edges.get(before.charAt(i)).add(next.charAt(i));
                return;
            }
            i++;
        }
        // 当给出的字符串数组错误时，valid = false
        if (before.length() > next.length()) {
            valid = false;
        }
    }

    // 深度优先，寻找相对顺序，先找到顺序最后的点
    void dfs(char c) {
        states.put(c, VISITING);
        List<Character> characters = edges.get(c);
        for (Character character : characters) {
            if (!states.containsKey(character)) {
                dfs(character);
                if (!valid) {
                    return;
                }
            } else if (states.get(character) == VISITING) {
                valid = false;
                return;
            }
        }
        states.put(c, VISITED);
        order[index--] = c;
    }

    public static void main(String[] args) {
        System.out.println('w' - 'a');
        System.out.println('r' - 'a');
        System.out.println('t' - 'a');
        System.out.println('f' - 'a');
        System.out.println('e' - 'a');
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        Solution solution = new Solution();
        System.out.println(solution.alienOrder(words));
    }
}
