package meeting.bytedance.code_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[][] arr = new String[n][m];
        // 0-red, 1-green, 2-blue
        int[][][] colors = new int[n + 1][m + 1][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.next();
                colors[i + 1][j + 1][0] = colors[i][j + 1][0] + colors[i + 1][j][0] - colors[i][j][0];
                colors[i + 1][j + 1][1] = colors[i][j + 1][1] + colors[i + 1][j][1] - colors[i][j][1];
                colors[i + 1][j + 1][2] = colors[i][j + 1][2] + colors[i + 1][j][2] - colors[i][j][2];
                if (arr[i][j].equals("red")) {
                    colors[i + 1][j + 1][0] += 1;
                } else if (arr[i][j].equals("green")) {
                    colors[i + 1][j + 1][1] += 1;
                } else {
                    colors[i + 1][j + 1][2] += 1;
                }
            }
        }
        int q = sc.nextInt();
        while (q > 0) {
            int x1 = sc.nextInt() - 1;
            int y1 = sc.nextInt() - 1;
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int ans = 0;
            // red
            if (colors[x2][y2][0] - colors[x1][y2][0] - colors[x2][y1][0] + colors[x1][y1][0] > 0) {
                ans++;
            }
            // red
            if (colors[x2][y2][1] - colors[x1][y2][1] - colors[x2][y1][1] + colors[x1][y1][1] > 0) {
                ans++;
            }
            // red
            if (colors[x2][y2][2] - colors[x1][y2][2] - colors[x2][y1][2] + colors[x1][y1][2] > 0) {
                ans++;
            }
            System.out.println(ans);
            q--;
        }
    }
}