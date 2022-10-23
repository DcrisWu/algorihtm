package BinarySearch;

/**
 * code_1201
 */
public class twenty_1 {
    public static void main(String[] args) {
        twenty_1 twenty_1 = new twenty_1();
        System.out.println(twenty_1.nthUglyNumber(24, 22, 11, 19));
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = (long) a * b / gcd(a, b);
        long ac = (long) a * c / gcd(a, c);
        long bc = (long) b * c / gcd(b, c);
        long abc = (long) a * b * c;
        long temp_lcm = (long) a * b / gcd(a, b);
        long lcm = temp_lcm * c / gcd(temp_lcm, c);
        //每lcm个连续整数中，就有circle个丑数
        long circle = lcm / a + lcm / b + lcm / c - lcm / ab - lcm / ac - lcm / bc + 1L;
        int m = (int) (n / circle);
        int k = (int) (n % circle);
        long l = 0, r = lcm, ans = 0;
        while (l <= r) {
            long mid = (l + r) >> 1;
            long temp = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / lcm;
            if (temp >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) (m * lcm + ans);

    }

    public long gcd(long a, long b) {
        long max = Math.max(a, b);
        long min = a == max ? b : a;
        if (max % min == 0) {
            return min;
        } else {
            return gcd(min, max % min);
        }
    }
}
