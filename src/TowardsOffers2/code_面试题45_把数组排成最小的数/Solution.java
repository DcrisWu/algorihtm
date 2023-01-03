package TowardsOffers2.code_面试题45_把数组排成最小的数;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public String minNumber(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> {
            String t1 = String.valueOf(a) + String.valueOf(b);
            String t2 = String.valueOf(b) + String.valueOf(a);
            return t1.compareTo(t2);
        });
        for (int num : nums) {
            queue.add(num);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();


    }
}
