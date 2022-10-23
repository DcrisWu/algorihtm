package DataStructure;

import java.util.Arrays;
import java.util.Comparator;


public class july_4_2 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {

                return a[1] - b[1];
            }
        });
        for (int[] interval : intervals) {
            for (int i : interval) {
                System.out.print(i);
                System.out.print(' ');
            }
            System.out.println();
        }
        /**
         * 先按照右边界排好序
         * 然后选择第一个区间，再遍历，选择右边第一个左区间大于已有的右区间的区间
         */
        int ans = 1;
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }
        return intervals.length - ans;

    }

    public static void main(String[] args) {
        int[][] arr = {{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
        eraseOverlapIntervals(arr);
    }
}
