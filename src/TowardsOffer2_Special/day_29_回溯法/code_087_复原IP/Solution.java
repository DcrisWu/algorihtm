package TowardsOffer2_Special.day_29_回溯法.code_087_复原IP;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2022.11.8
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> init = new ArrayList<>();
        backTrack(ans, s, init, 0);
        return ans;
    }

    void backTrack(List<String> ans, String s, List<String> pre, int index) {
        if (pre.size() == 4) {
            if (index >= s.length()) {
                StringBuilder now = new StringBuilder(new String(""));
                for (String s1 : pre) {
                    now.append(s1).append(".");
                }
                now.delete(now.length() - 1, now.length());
                ans.add(now.toString());
            }
            return;
        }
        for (int i = index; i < Math.min(s.length(), i + 3); i++) {
            String bits = s.substring(index, i + 1);
            if (Integer.parseInt(bits) > 255) {
                break;
            }
            pre.add(bits);
            backTrack(ans, s, pre, i + 1);
            pre.remove(pre.size() - 1);
            if (bits.equals("0")) {
                break;
            }
        }
    }
}
