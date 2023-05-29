package basicAlgorithm.day_6.code_547;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * completion time = 2022.9.18
 */
public class Solution {
    public static void main(String[] args) {
        int[][] arr = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(arr));
    }

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] mark = new boolean[n];
        int fuck = 2;
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            boolean judge = false;
            while (!queue.isEmpty()) {
                int index = queue.poll();
                for (int k = 0; k < n; k++) {
                    if(k == index){
                        continue;
                    }
                    if (isConnected[index][k] == 1) {
                        mark[index] = true;
                        mark[k] = true;
                        judge = true;
                        isConnected[index][k] = 2;
                        queue.add(k);
                    }
                }
            }
            if(judge){
                count++;
            }
        }
        for (boolean b : mark) {
            if (!b) {
                count++;
            }
        }
        return count;
    }
}