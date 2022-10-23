package BasicCoding.day_2.code_459;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * completion time = 2022.10.1
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);

        /*Set<String> model = new HashSet<>();
        for (int i = 1; i <= s.length() / 2; i++) {
            model.add(s.substring(0, i));
        }
        for (String s1 : model) {
            boolean judge = true;
            for (int i = 0; i < s.length(); i += s1.length()) {
                if(s.length()-i < s1.length()){
                    judge = false;
                    break;
                }
                if (!s.substring(i, i + s1.length()).equals(s1)) {
                    judge = false;
                    break;
                }
            }
            if (judge) {
                return true;
            }
        }
        return false;*/
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("abab"));
    }
}
