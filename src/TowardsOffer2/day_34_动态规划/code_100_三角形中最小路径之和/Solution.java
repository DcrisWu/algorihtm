package TowardsOffer2.day_34_动态规划.code_100_三角形中最小路径之和;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2022.11.13
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> pre = new ArrayList<>();
        pre.add(triangle.get(0).get(0));
        int min = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            List<Integer> now = new ArrayList<>(list.size());
            now.add(pre.get(0) + list.get(0));
            min = pre.get(0) + list.get(0);
            for (int j = 1; j < list.size() - 1; j++) {
                now.add(Math.min(pre.get(j - 1), pre.get(j)) + list.get(j));
                min = Math.min(min, now.get(j));
            }
            now.add(pre.get(pre.size() - 1) + list.get(list.size() - 1));
            min = Math.min(min, now.get(now.size() - 1));
            pre = now;
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        Solution solution = new Solution();
        System.out.println(solution.minimumTotal(list));
    }
}