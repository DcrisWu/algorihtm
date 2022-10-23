package BinarySearch;

import java.awt.*;
import java.util.Arrays;

/**
 * code_436
 */
public class eleven_2 {
    public static void main(String[] args) {
        int[][] arr = {{3, 4}, {2, 3}, {1, 2}};
        findRightInterval(arr);
    }

    public static int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Point[] x = new Point[n];
        for (int i = 0; i < n; i++) {
            x[i] = new Point(intervals[i][0], i);
        }
        Arrays.sort(x, (a, b) -> a.x - b.x);
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            int endValue = intervals[i][1];
            int mark = -1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                int temp = x[mid].x;
                if (temp >= endValue) {
                    r = mid - 1;
                    mark = mid;
                } else {
                    l = mid + 1;
                }
            }
            if(mark != -1){
                ans[i] = x[mark].y;
            }
        }
        return ans;
    }
}
