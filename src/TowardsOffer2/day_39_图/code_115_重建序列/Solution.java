package TowardsOffer2.day_39_图.code_115_重建序列;

import java.util.*;

/**
 * completion time = 2022.11.18
 * 拓扑排序也可以用广度优先
 */
class Solution {
    private Map<Integer, List<Integer>> edges = new HashMap<>();
    private int[] order;
    Map<Integer, Integer> seen = new HashMap<>();

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                edges.putIfAbsent(sequence[i - 1], new ArrayList<>());
                edges.get(sequence[i - 1]).add(sequence[i]);
            }
        }
        order = new int[nums.length];
        int fin = nums.length - 1;
        for (int num : nums) {
            if (!seen.containsKey(num)) {
                int dfs = dfs(num);
                if (dfs == -1) {
                    return false;
                }
                fin = Math.min(fin, dfs);
            }
        }
        return fin == 0;
    }

    int dfs(int num) {
        if (seen.containsKey(num)) {
            return seen.get(num);
        }
        if (!edges.containsKey(num)) {
            if (order[order.length - 1] == 0) {
                seen.put(num, order.length - 1);
                order[order.length - 1] = num;
                return order.length - 1;
            } else {
                return -1;
            }
        }
        int level = order.length - 1;
        for (Integer integer : edges.get(num)) {
            int dfs = dfs(integer);
            if (dfs == -1) {
                return -1;
            }
            level = Math.min(level, dfs - 1);
        }
        if (order[level] == 0) {
            seen.put(num, level);
            order[level] = num;
            return level;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 5, 2, 6, 3};
        int[][] sequences = {{5, 2, 6, 3}, {4, 1, 5, 2}};
        Solution solution = new Solution();
        System.out.println(solution.sequenceReconstruction(nums, sequences));
    }
}
