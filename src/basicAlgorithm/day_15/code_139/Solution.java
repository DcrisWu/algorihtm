package basicAlgorithm.day_15.code_139;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * completion time = 2022.9.26
 */
public class Solution {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> strings = new LinkedList<>();
        strings.add("leet");
        strings.add("code");
        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, strings));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //将一个子串分成任意两段，前半段绝对是已经判断过的
        //只要前半段为真，字典中存在后半段，这一段子串就成立
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
