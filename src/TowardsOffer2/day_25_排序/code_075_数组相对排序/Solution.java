package TowardsOffer2.day_25_排序.code_075_数组相对排序;

import java.util.*;

/**
 * completion time = 2022.11.5
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1.length == arr2.length) {
            return arr2;
        }
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> rest = new ArrayList<>();
        for (int k : arr2) {
            count.putIfAbsent(k, 0);
        }
        for (int j : arr1) {
            if (count.containsKey(j)) {
                count.put(j, count.get(j) + 1);
            } else {
                rest.add(j);
            }
        }
        rest.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int k : arr2) {
            for (int j = 0; j < count.get(k); j++) {
                ans[index++] = k;
            }
        }
        for (Integer integer : rest) {
            ans[index++] = integer;
        }
        return ans;
    }
}