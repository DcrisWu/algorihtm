package BinarySearch;

import java.util.Arrays;

/**
 * code_1802
 */
public class seventeen_1 {
    public int maxValue(int n, int index, int maxSum) {
        int res = maxSum - n, ans = 1;
        int l = index, r = index;
        while (l > 0 || r < n - 1) {
            int len = r - l + 1;
            if (res >= len) {
                res -= len;
                ans++;
                l = Math.max(0, l - 1);
                r = Math.min(n - 1, r + 1);
            }else {
                break;
            }
        }
        //循环结束后，形成了一个阶梯，如果再想往index处＋1，只能把数组所有的项都+1
        ans += res / n;
        return ans;
    }
}
