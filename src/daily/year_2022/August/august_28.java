package daily.year_2022.August;

public class august_28 {

    public static void main(String[] args) {
        august_28 august_28 = new august_28();
        System.out.println(august_28.preimageSizeFZF(6));
    }

    public long f(long x) {
        long ans = 0L;
        for(x /= 5;x != 0;x /= 5)
            ans += x;
        return ans;
    }

    public int preimageSizeFZF(int k) {
        long l = 4L * k, r = 5L * k;
        while (l < r) {
            long m = (l + r) >> 1;
            if (f(m) < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return f(l) == k ? 5 : 0;
    }
}
