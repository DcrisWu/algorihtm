package meeting.webank.code_3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private int[] p;
    private int[] count;

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt() - 1;
        int t = sc.nextInt() - 1;
        p = new int[n];
        count = new int[n];
        Arrays.fill(p, -1);
        Arrays.fill(count, 1);
        long temp = ((long) (n - 1) * (n - 2)) - m;
        while (m > 0) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            merge(x, y);
            m--;
        }
        int sp = getParent(s);
        int st = getParent(t);
        long i = count[sp];
        long j = count[st];
        if (sp != st) {
            System.out.println(i * j);
        } else {
            System.out.println(temp);
        }
    }

    // j指向i
    void merge(int i, int j) {
        int p1 = getParent(i);
        int p2 = getParent(j);
        if (p1 != p2) {
            p[p2] = p1;
            count[p1] += count[p2];
            count[p2] = 0;
        }
    }

    int getParent(int i) {
        if (p[i] == -1) {
            return i;
        }
        int parent = getParent(p[i]);
        p[i] = parent;
        return parent;
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}
