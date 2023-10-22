package meeting.futu.code_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            long n = sc.nextInt();
            long m = sc.nextInt();
            long seven = (long) (0.7 * m);
            long three = (long) (0.3 * m);
            long times = n / m;
            long rest = n % m;
            if (rest == 0) {
                System.out.print(times);
                System.out.print(" ");
                System.out.println(m);
            } else {
                long last = 0;
                if (rest >= seven) {
                    if (rest == seven) {
                        times++;
                        last = rest;
                    } else {
                        times += 2;
                        last = rest - seven;
                    }
                } else if (rest >= three) {
                    if (rest > three * 2) {
                        times += 3;
                        last = rest - three * 2;
                    } else if (rest == three * 2) {
                        times += 2;
                        last = three;
                    } else if (rest > three) {
                        times += 2;
                        last = rest - three;
                    } else {
                        times++;
                        last = rest;
                    }
                } else {
                    times++;
                    last = rest;
                }

                System.out.print(times);
                System.out.print(" ");
                System.out.println(last);
            }

        }
    }
}