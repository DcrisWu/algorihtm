package daily.year_2022.August;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class august_8 {

    public static void main(String[] args) {
        makeLargestSpecial("11011000");
    }

    /**
     * 先拆分了每个符合要求的子串，然后进行排序重新组合，利用了栈的思想
     * @param s
     * @return
     */
    public static String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int cnt = 0, left = 0;
        List<String> subs = new ArrayList<String>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                ++cnt;
            } else {
                --cnt;
                if (cnt == 0) {
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        Collections.sort(subs, (a, b) -> b.compareTo(a));
        StringBuilder ans = new StringBuilder();
        for (String sub : subs) {
            ans.append(sub);
        }
        return ans.toString();
    }

}
