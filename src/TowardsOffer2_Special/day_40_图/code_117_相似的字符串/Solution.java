package TowardsOffer2_Special.day_40_图.code_117_相似的字符串;

import java.util.LinkedList;
import java.util.Queue;

/**
 * completion time = 2022.11.18
 */
class Solution {
    private boolean[] seen;

    public int numSimilarGroups(String[] strs) {
        seen = new boolean[strs.length];
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            if (!seen[i]) {
                bfs(strs, i);
                count++;
            }
        }
        return count;
    }

    void bfs(String[] strs, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        seen[i] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int j = 0; j < strs.length; j++) {
                if (!seen[j] && isSimilar(strs[poll], strs[j])) {
                    seen[j] = true;
                    queue.add(j);
                }
            }
        }
    }

    boolean isSimilar(String before, String next) {
        int first = -1, second = -1;
        for (int i = 0; i < before.length(); i++) {
            if (before.charAt(i) != next.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        return (first == second) || (before.charAt(first) == next.charAt(second) && before.charAt(second) == next.charAt(first));
    }
}
