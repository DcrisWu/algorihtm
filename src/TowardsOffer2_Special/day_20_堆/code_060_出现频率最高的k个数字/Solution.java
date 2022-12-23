package TowardsOffer2_Special.day_20_堆.code_060_出现频率最高的k个数字;

import java.util.*;

/**
 * completion time = 2022.10.31
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> treeSet = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.getOrDefault(o1, 0) - map.getOrDefault(o2, 0);

            }
        });
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer integer : map.keySet()) {
            if (treeSet.size() < k) {
                treeSet.add(integer);
            } else {
                treeSet.add(integer);
                treeSet.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = treeSet.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 1, -1, 2, -1, 2, 3};
        for (int i : solution.topKFrequent(arr, 2)) {
            System.out.println(i);
        }
    }
}
