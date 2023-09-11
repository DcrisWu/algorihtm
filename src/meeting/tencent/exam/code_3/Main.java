package meeting.tencent.exam.code_3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        long ans = 0;
        int fight = 0;
        int i = 0, j = a.length - 1;
        while (i <= j) {
            // 先与战斗力最强的打
            ans += a[j] - fight;
            fight = a[j];
            j--;
            if (i <= j && a[i] <= fight) {
                fight = a[i];
                i++;
            }
        }
        System.out.println(ans);
    }
}
