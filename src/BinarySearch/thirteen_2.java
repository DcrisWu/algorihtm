package BinarySearch;

import java.util.Random;

/**
 * code_528
 */
public class thirteen_2 {
    public static void main(String[] args) {
        int[] arr = {3,14,1,7};
        thirteen_2 thirteen_2 = new thirteen_2(arr);
        System.out.println(thirteen_2.pickIndex());
    }

    private long num;
    private long[] p;
    private Random random;

    public thirteen_2(int[] w) {
        num = w[0];
        p = new long[w.length];
        for (int i = 1; i < w.length; i++) {
            num += w[i];
            p[i] = p[i - 1] + w[i - 1];
        }
        random = new Random();
    }

    public int pickIndex() {
//        long nextLong = Math.abs(random.nextLong() % num);
        long nextLong = 17;
        int l = 0, r = p.length - 1, ans = r;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (p[mid] <= nextLong) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
