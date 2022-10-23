package BasicCoding.day_11.code_1376;

import java.util.*;

/**
 * completion time = 2022.10.8
 */
public class Solution {
    List<Integer>[] subordinatesArr;
    int[] informTime;
    int maxTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.subordinatesArr = new List[n];
        for (int i = 0; i < n; i++) {
            subordinatesArr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            if (i != headID) {
                subordinatesArr[manager[i]].add(i);
            }
        }
        this.informTime = informTime;
        this.maxTime = 0;
        dfs(headID, 0);
        return maxTime;
    }

    public void dfs(int id, int time) {
        maxTime = Math.max(maxTime, time);
        List<Integer> subordinates = subordinatesArr[id];
        int nextTime = time + informTime[id];
        for (int subordinate : subordinates) {
            dfs(subordinate, nextTime);
        }
    }
}
