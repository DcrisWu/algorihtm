package meeting.sf.code_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        while (n != 0) {
            int root = getRoot(n);
            n -= root * root;
            ans += root * 4;
        }
        System.out.println(ans);
    }

    public static int getRoot(int num) {
        double sqrt = Math.sqrt(num);
        return (int) sqrt;
    }
}
