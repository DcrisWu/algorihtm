package meeting.jinshan.code_3;

import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            String a = sc.next();
            String b = sc.next();
            System.out.println(cal(a, b));
        }
    }

    public static int cal(String a, String b) {
        int ia = 0, ib = 0, ja = a.length() - 1, jb = b.length() - 1;
        int ans = 0;
        while (ia <= ja && ib <= jb) {
            if (a.charAt(ia) == a.charAt(ja)) {
                ia++;
                ja--;
                ans += 2;
            } else if (b.charAt(ib) == b.charAt(jb)) {
                ib++;
                jb--;
                ans += 2;
            } else if (a.charAt(ia) == b.charAt(jb)) {
                ia++;
                jb--;
                ans += 2;
            } else if (b.charAt(ib) == a.charAt(ja)) {
                ib++;
                ja--;
                ans += 2;
            } else {
                ia++;
                ib++;
                ja--;
                jb--;
            }
        }
        return ans;
    }
}
