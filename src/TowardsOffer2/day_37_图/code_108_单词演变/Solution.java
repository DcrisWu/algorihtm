package TowardsOffer2.day_37_图.code_108_单词演变;

import java.util.*;

/**
 * completion time = 2022.11.16
 */
class Solution {
    Map<String, Integer> map = new HashMap<>();
    List<List<Integer>> edge = new ArrayList<>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String s : wordList) {
            addEdge(s);
        }
        if (!map.containsKey(endWord)) {
            return 0;
        }
        addEdge(beginWord);
        Integer beginId = map.get(beginWord);
        int[] dis = new int[edge.size()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[beginId] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(beginId);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (Objects.equals(poll, map.get(endWord))) {
                return dis[poll] / 2 + 1;
            }
            List<Integer> list = edge.get(poll);
            for (Integer integer : list) {
                if (dis[integer] == Integer.MAX_VALUE) {
                    dis[integer] = dis[poll] + 1;
                    queue.offer(integer);
                }
            }
        }
        return 0;
    }

    void addEdge(String word) {
        addWord(word);
        Integer beginId = map.get(word);
        char[] array = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char temp = array[i];
            array[i] = '*';
            String s = new String(array);
            addWord(s);
            Integer targetId = map.get(s);
            edge.get(beginId).add(targetId);
            edge.get(targetId).add(beginId);
            array[i] = temp;
        }
    }

    void addWord(String world) {
        if (!map.containsKey(world)) {
            map.put(world, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }
}
