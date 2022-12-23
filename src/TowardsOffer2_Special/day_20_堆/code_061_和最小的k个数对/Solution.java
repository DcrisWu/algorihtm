package TowardsOffer2_Special.day_20_堆.code_061_和最小的k个数对;

import java.util.*;

/**
 * Mark!
 * completion time = 2022.10.31
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums1[i]);
                temp.add(nums2[j]);
                queue.add(temp);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        List<List<Integer>> ans = new LinkedList<>();
        int n = queue.size();
        for (int m = 0; m < Math.min(k, n); m++) {
            ans.add(0,queue.poll());
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.kSmallestPairs(nums1, nums2, 10));
    }
}
