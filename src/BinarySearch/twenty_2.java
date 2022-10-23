package BinarySearch;

import java.util.*;

/**
 * code_911
 */
public class twenty_2 {
    public static void main(String[] args) {
        int[] person = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        twenty_2 twenty_2 = new twenty_2(person, times);
        System.out.println(twenty_2.q(1));
    }

    private HashMap<Integer, Integer> map;
    private int[] ans;
    private int[] timing;

    public twenty_2(int[] persons, int[] times) {
        int n = persons.length;
        timing = new int[n];
        System.arraycopy(times, 0, timing, 0, n);
        map = new HashMap<>();
        ans = new int[n];
        map.putIfAbsent(persons[0], 1);
        ans[0] = persons[0];
        for (int i = 1; i < n; i++) {
            if (!map.containsKey(persons[i])) {
                map.putIfAbsent(persons[i], 1);
            } else {
                map.replace(persons[i], map.get(persons[i]) + 1);
            }
            if (map.get(persons[i]) >= map.get(ans[i - 1])) {
                ans[i] = persons[i];
            } else {
                ans[i] = ans[i - 1];
            }
        }
    }

    public int q(int t) {
        int re = ans[0];
        int n = ans.length;
        int l = 0, r = n-1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (timing[mid] <= t) {
                re = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans[re];
    }
}
