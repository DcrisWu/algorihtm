package competition.leetcode_weekly.No_339_day_2023_4_2.code_6364_老鼠和奶酪;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        if (k == n) {
            return Arrays.stream(reward1).sum();
        }
        if (k == 0) {
            return Arrays.stream(reward2).sum();
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        for (int i = 0; i < n; i++) {
            int[] tmp = {i, reward1[i] - reward2[i]};
            if (queue.size() == k) {
                int[] peek = queue.peek();
                if (peek[1] < tmp[1]) {
                    queue.poll();
                    queue.add(tmp);
                }
            } else {
                queue.add(tmp);
            }
        }
        int ans = 0;
        boolean[] mark = new boolean[n];
        for (int[] ints : queue) {
            mark[ints[0]] = true;
            ans += reward1[ints[0]];
        }
        for (int i = 0; i < n; i++) {
            if (!mark[i]){
                ans += reward2[i];
            }
        }
        return ans;

    }
}