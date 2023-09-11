package meeting.tencent.exam.code_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            List<Integer> alist = new ArrayList<>();
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                alist.add(a[i]);
            }
            for (int i = 0; i < n - 1; i++) {
                b[i] = sc.nextInt() - 1;
            }
            alist.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int i = 0; i < b.length; i++) {
                if (alist.size() % 2 == 1) {
                    int pivot = alist.size() / 2;
                    System.out.print(alist.get(pivot));
                    System.out.print(" ");
                    int needDel = a[b[i]];
                    int idx = alist.indexOf(needDel);
                    alist.remove(idx);
                } else {
                    int second = alist.size() / 2;
                    int first = second - 1;
                    int sum = alist.get(first) + alist.get(second);
                    if (sum % 2 == 0) {
                        System.out.print(sum / 2);
                    } else {
                        double p = sum * 1d / 2d;
                        System.out.print(p);
                    }
                    System.out.print(" ");
                    int needDel = a[b[i]];
                    int idx = alist.indexOf(needDel);
                    alist.remove(idx);
                }
            }
            System.out.println(alist.get(0));
            t--;
        }
    }
}
