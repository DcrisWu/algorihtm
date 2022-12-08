package Random.code_127_单词接龙;

import java.util.*;

class Solution {
    private Map<String, Integer> map = new HashMap<>();
    private List<List<Integer>> edge = new ArrayList<>();
    int numNode = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String s : wordList) {
            addEdge(s);
        }
        addEdge(beginWord);
        if (!map.containsKey(endWord)) {
            return 0;
        }
        Integer endId = map.get(endWord);
        int[] length = new int[numNode];
        Arrays.fill(length, Integer.MAX_VALUE);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(map.get(beginWord));
        length[map.get(beginWord)] = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (endId.equals(poll)) {
                return length[poll] / 2 + 1;
            }
            for (Integer integer : edge.get(poll)) {
                if (length[integer] == Integer.MAX_VALUE){
                    length[integer] = length[poll] + 1;
                    queue.add(integer);
                }
            }
        }
        return 0;
    }

    void addEdge(String word) {
        addWord(word);
        Integer wordId = map.get(word);
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            chars[i] = '*';
            String newWord = new String(chars);
            addWord(newWord);
            Integer id = map.get(newWord);
            edge.get(wordId).add(id);
            edge.get(id).add(wordId);
            chars[i] = temp;
        }
    }

    void addWord(String word) {
        if (!map.containsKey(word)) {
            map.put(word, numNode++);
            edge.add(new ArrayList<>());
        }
    }
}
