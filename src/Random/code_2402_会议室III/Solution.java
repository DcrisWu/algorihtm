package Random.code_2402_会议室III;

import java.util.Arrays;
import java.util.Comparator;

/**
 * completion time = 2023.8.21
 */
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        long[] heap = new long[n];
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        for (int[] meeting : meetings) {
            int idx = 0;
            boolean used = false;
            for (int i = 0; i < n; i++) {
                if (heap[i] == 0 || (heap[i] <= meeting[0])) {
                    heap[i] = meeting[1];
                    used = true;
                    count[i]++;
                    break;
                } else {
                    if (heap[i] < heap[idx]) {
                        idx = i;
                    }
                }
            }
            if (!used) {
                heap[idx] += meeting[1] - meeting[0];
                count[idx]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}
