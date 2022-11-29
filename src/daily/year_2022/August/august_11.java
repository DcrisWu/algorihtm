package daily.year_2022.August;

import java.util.ArrayList;
import java.util.List;

public class august_11 {
    public String reformat(String s) {
        List<Character> characters = new ArrayList<>();
        List<Character> numbers = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                numbers.add(ch);
            } else {
                characters.add(ch);
            }
        }
        int m = characters.size(), k = numbers.size();
        if (m > k + 1 || m < k - 1) {
            return "";
        }
        StringBuilder ans = new StringBuilder("");
        int index = 0;

        while (index < m && index < k) {
            ans.append(characters.get(index));
            ans.append(numbers.get(index));
            index++;
        }
        if (m == k) {
            return ans.toString();
        } else if (m > k) {
            return ans.toString() + characters.get(index);
        } else {
            return numbers.get(index) + ans.toString();
        }
    }
}