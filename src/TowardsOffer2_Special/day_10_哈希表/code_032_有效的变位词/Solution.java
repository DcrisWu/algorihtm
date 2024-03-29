package TowardsOffer2_Special.day_10_哈希表.code_032_有效的变位词;

import java.util.Arrays;

/**
 * completion time = 2022.10.22
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        int[] arr_s = new int[26];
        int[] arr_t = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr_s[s.charAt(i) - 'a'] += 1;
            arr_t[t.charAt(i) - 'a'] += 1;
        }
        return Arrays.equals(arr_s, arr_t);
    }
}
