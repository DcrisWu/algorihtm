package classification.top_k.code_692_前K个高频单词;

import java.util.*;

/**
 * completion time = 2023.8.15
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        TreeSet<String> s = new TreeSet<>((a, b) -> {
            if (!count.get(a).equals(count.get(b))) {
                return count.get(b) - count.get(a);
            }
            return a.compareTo(b);
        });
        s.addAll(count.keySet());
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(s.pollFirst());
        }
        return ans;
    }
}
