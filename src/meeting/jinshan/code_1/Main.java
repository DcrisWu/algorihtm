package meeting.jinshan.code_1;

import java.util.Scanner;

/**
 * completion time = 2023.9.28
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = 1;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[j] - arr[j - 1] <= 8) {
                if (j - i + 1 > ans) {
                    ans = j - i + 1;
                }
            } else {
                i = j;
            }
        }
        System.out.println(ans);
    }
}