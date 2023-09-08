package meeting.shein.code_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        String s = split[0];
        int m = Integer.parseInt(split[1]);
        char[][] arr = new char[m][1000];
        int i = 0;
        int x = 0, y = 0;
        while (i < s.length()) {
            // 从上到下
            while (i < s.length() && x < m) {
                arr[x][y] = s.charAt(i);
                x++;
                i++;
            }
            x = m - 2;
            y++;
            // 斜边
            while (i < s.length() && x > 0) {
                arr[x][y] = s.charAt(i);
                x--;
                y++;
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < y; k++) {
                if (arr[j][k] != 0){
                    sb.append(arr[j][k]);
                }
            }
        }
        System.out.println(sb);
    }
}
