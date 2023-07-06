package competition.leetcode_weekly.No_352_day_2023_7_2.code_6916_和等于目标值的质数对;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2023.7.2
 */
class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 2; i <= n - i; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(n - i);
                ans.add(tmp);
            }
        }
        return ans;
    }

    boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
