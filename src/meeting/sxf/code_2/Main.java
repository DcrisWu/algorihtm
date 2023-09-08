package meeting.sxf.code_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        // 按照实力升序排列
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        long max = 0;
        long now = 0;
        for (int i = 0, j = 0; j < n; j++) {
            now += arr[j][1];
            while (i < j && arr[j][0] - arr[i][0] >= d) {
                now -= arr[i][1];
                i++;
            }
            max = Math.max(now, max);
        }
        System.out.println(max);
    }
}
