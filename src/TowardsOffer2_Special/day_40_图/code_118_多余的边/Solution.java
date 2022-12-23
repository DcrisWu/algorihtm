package TowardsOffer2_Special.day_40_图.code_118_多余的边;

import java.util.*;

class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int[] ans = null;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.putIfAbsent(edges[i][0], new HashSet<>());
            map.get(edges[i][0]).add(edges[i][0]);
            // 如果这个数不属于任何一个集合，就加入那个集合
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], map.get(edges[i][0]));
                map.get(edges[i][1]).add(edges[i][1]);
                // 如果这个数和另一个数是两个集合，就合并
            } else if (map.get(edges[i][0]) != map.get(edges[i][1])) {
                map.get(edges[i][0]).addAll(map.get(edges[i][1]));
                for (Integer integer : map.get(edges[i][1])) {
                    map.put(integer, map.get(edges[i][0]));
                }
                //如果是同一个集合，就是存在环，就是答案
            } else {
                ans = edges[i];
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {{1, 2}, {3, 4}, {2, 3}, {1, 4}, {1, 5}};
        for (int i : solution.findRedundantConnection(edges)) {
            System.out.println(i);
        }
    }
}
