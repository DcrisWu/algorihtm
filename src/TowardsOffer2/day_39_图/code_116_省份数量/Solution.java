package TowardsOffer2.day_39_图.code_116_省份数量;

import java.util.HashSet;
import java.util.Set;

/**
 * completion time = 2022.11.18
 */
class Solution {

    public int findCircleNum(int[][] isConnected) {

        int count = isConnected.length;
        for (int i = 0; i < isConnected.length; i++) {
            Set<Integer> seen = new HashSet<>();
            dfs(isConnected, i, seen);
            if (!seen.isEmpty()){
                count -= seen.size() - 1;
            }

        }
        return count;
    }

    void dfs(int[][] cities, int city, Set<Integer> seen) {
        if (cities[city][city] == 1) {
            cities[city][city] = 0;
            seen.add(city);
        }
        for (int i = 0; i < cities.length; i++) {
            if (cities[city][i] == 1) {
                cities[city][i] = 0;
                cities[i][city] = 0;
                seen.add(i);
                dfs(cities, i, seen);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(arr));
    }
}