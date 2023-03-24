package TME.code_2;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaxValue("ababbbb", 2));
    }

    public int getMaxValue(String str, int k) {
        int l = 0, r = Integer.MAX_VALUE;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(str, k, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    boolean check(String str, int k, int target) {
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        while (k > 0 && r < str.length()) {
            set.add(str.charAt(r));
            if ((r - l + 1) * set.size() > target) {
                l = r;
                k--;
                set.clear();
                set.add(str.charAt(r));
            }
            r++;
        }
        return r >= str.length() - 1;
    }
}
