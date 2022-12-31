package TowardsOffers2.code_49_丑数;

import java.util.SortedSet;
import java.util.TreeSet;

class Solution {
    public int nthUglyNumber(int n) {
        SortedSet<Long> set = new TreeSet<>();
        set.add(1L);
        int first = 2;
        int second = 3;
        int third = 5;
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = set.first();
            set.remove(ans);
            set.add(ans * first);
            set.add(ans * second);
            set.add(ans * third);
        }
        return (int)ans;
    }

    boolean isUgly(int n) {
        int first = 2;
        int second = 3;
        int third = 5;
        if (n == first || n == second || n == third) {
            return true;
        }
        if (n % first == 0) {
            return isUgly(n / first);
        } else if (n % second == 0) {
            return isUgly(n / second);
        } else if (n % third == 0) {
            return isUgly(n / third);
        }
        return false;
    }


}
