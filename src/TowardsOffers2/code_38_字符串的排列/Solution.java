package TowardsOffers2.code_38_字符串的排列;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String[] permutation(String s) {
        boolean[] used = new boolean[s.length()];
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        backTrace(s, sb, used, set);
        String[] ans = new String[set.size()];
        int i = 0;
        for (String s1 : set) {
            ans[i++] = s1;
        }
        return ans;
    }

    void backTrace(String s, StringBuilder sb, boolean[] used, Set<String> set) {
        if (sb.length() == s.length()) {
            set.add(sb.toString());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                sb.append(s.charAt(i));
                used[i] = true;
                backTrace(s, sb, used, set);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
