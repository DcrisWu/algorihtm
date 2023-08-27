package meeting.jd.code_1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            int res = arr[i - 1] % i;
            int num = i - res;
            while (set.contains(num)) {
                num += i;
            }
            set.add(num);
            System.out.print(num);
            if (i != n) {
                System.out.print(" ");
            }
        }
    }
}
