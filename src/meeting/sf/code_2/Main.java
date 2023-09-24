package meeting.sf.code_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int idx = 0;
        int last = n - 1;
        while (k > 0 && idx < last) {
            if (a[idx] < k) {
                a[last] += a[idx];
                k -= a[idx];
                a[idx] = 0;
                idx++;
            } else {
                a[last] += k;
                a[idx] -= k;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }
}
