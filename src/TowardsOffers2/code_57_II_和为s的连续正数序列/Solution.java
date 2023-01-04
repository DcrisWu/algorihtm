package TowardsOffers2.code_57_II_和为s的连续正数序列;

import java.util.*;

class Solution {
    public int[][] findContinuousSequence(int target) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(1);
        deque.offerLast(2);
        int sum = 3;
        int m = 0, n = 0;
        List<List<Integer>> ans = new ArrayList<>();
        int last = 2;
        while (last < target) {
            if (sum == target) {
                m++;
                n = Math.max(n, deque.size());
                List<Integer> temp = new ArrayList<>(deque.size());
                for (Integer integer : deque) {
                    temp.add(integer);
                }
                ans.add(temp);
                sum -= deque.pollFirst();
                sum += ++last;
                deque.offerLast(last);
            } else if (sum < target) {
                deque.offerLast(++last);
                sum += last;
            } else {
                if (!deque.isEmpty()) {
                    sum -= deque.pollFirst();
                }
            }
        }
        int[][] ret = new int[m][];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[ans.get(i).size()];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = ans.get(i).get(j);
            }
            ret[i] = temp;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int[] ints : solution.findContinuousSequence(15)) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}