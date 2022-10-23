package daily;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;


public class july_23 {
    /**
     * 这是一个标准的拓扑排序
     * @param nums
     * @param sequences
     * @return
     */
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        //indegrees表示入度数组
        int[] indegrees = new int[n + 1];
        //graph数组存储的是子序列的下一个元素
        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<>();
        }
        //子序列的第一个元素作为下标，存储第二个元素，然后第二个元素的入度+1
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int pre = sequence[i-1];
                int next = sequence[i];
                if(graph[pre].add(next)){
                    indegrees[next]++;
                }
            }
        }
        //存储结果的队列，用于排序
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            //head表示queue的头元素，取出头元素并从队列中删除
            int head = queue.poll();
            Set<Integer> set = graph[head];
            for (Integer integer : set) {
                indegrees[integer]--;
                if (indegrees[integer] == 0) {
                    queue.add(integer);
                }
            }
        }
        return true;
    }
}
