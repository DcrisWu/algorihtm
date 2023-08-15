package classification.top_k.code_347_前K个高频元素;

import java.util.*;

/**
 * completion time = 2023.8.15
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        TreeSet<Integer> s = new TreeSet<>((o1, o2) -> {
            if (!Objects.equals(count.get(o1), count.get(o2))) {
                return count.get(o2) - count.get(o1);
            }
            return o1 - o2;
        });
        s.addAll(count.keySet());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = s.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(new Solution().topKFrequent(arr, 2));
    }
}
