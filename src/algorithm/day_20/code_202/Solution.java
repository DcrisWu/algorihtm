package algorithm.day_20.code_202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int pre = n;
        Set<Integer> set = new HashSet<>();
        set.add(pre);
        while (!set.contains(1)) {
            int now = 0;
            while (pre >= 10) {
                now += Math.pow((pre % 10), 2);
                pre /= 10;
            }
            now += Math.pow(pre, 2);
            if (now == 1) {
                return true;
            }
            if (set.contains(now)) {
                return false;
            }
            pre = now;
            set.add(now);
        }
        return true;
    }
}
