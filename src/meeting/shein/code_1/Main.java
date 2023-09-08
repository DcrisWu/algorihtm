package meeting.shein.code_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int have = 100;
        int pre = 0;
        int block = 0;
        while (m > 0) {
            int now = sc.nextInt();
            int req = sc.nextInt();
            have = Math.min(150, have + (now - pre) / 10);
            if (req > have) {
                block += req - have;
                have = 0;
            } else {
                have = have - req;
            }
            pre = now;
            m--;
        }
        System.out.println(block);
    }
}
