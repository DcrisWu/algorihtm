package BinarySearch;

import java.util.*;

/**
 * code_1482
 */
public class seven_1 {
    public static void main(String[] args) {
        int[] arr = {12,83,63,97,20,1,70,95,22,48,47,60,63,64,79,43,95,14,11,71,83,10,71,47,95,23,23,79,24,46,94,37};
//        Arrays.sort(arr);
        seven_1 seven_1 = new seven_1();
        System.out.println(seven_1.minDays(arr, 4, 7));
    }
    public int minDays(int[] bloomDay, int m, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = bloomDay.length;
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(bloomDay[i], new ArrayList<>());
            map.get(bloomDay[i]).add(i);
        }
        int size = map.keySet().size();
        Object[] array = map.keySet().toArray();
        Arrays.sort(array);
        int ans = -1, left = 21, right = size - 1;
        while (left <= right) {
            boolean[] state = new boolean[n];
            int mid = (left + right) >> 1;
            for (int i = 0; i <= mid; i++) {
                for (Integer integer : map.get(array[i])) {
                    state[integer] = true;
                }
            }
            int j = 0, cnt = 0;
            while (j < n) {
                int cal = 0;
                while (j < n && state[j] == true) {
                    cal++;
                    if (cal == k) {
                        cnt++;
                        cal = 0;
                    }
                    j++;
                }
                j++;
            }
            if (cnt >= m) {
                right = mid - 1;
                ans = (int) array[mid];
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
