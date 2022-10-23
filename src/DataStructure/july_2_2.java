package DataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Math.max;

public class july_2_2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            /**
             * a,b分别表示两个数组，这两个数组都是二维数组里面的元素
             * a[0],a[1]表示二维数组的第二层元素
             */
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        int[][] ans = new int[intervals.length][2];
        int j = 0;
        ans[0][0] = intervals[0][0];
        ans[0][1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= ans[j][1]) {
                ans[j][1] = max(intervals[i][1], ans[j][1]);
            } else {
                ++j;
                ans[j][0] = intervals[i][0];
                ans[j][1] = intervals[i][1];
            }
        }
        int[][] answer = new int[j + 1][2];
        for (int i = 0; i <= j; i++) {
            answer[i][0] = ans[i][0];
            answer[i][1] = ans[i][1];
        }
        return answer;
    }

}
