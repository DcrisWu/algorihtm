package daily.year_2022.August;

import java.util.ArrayList;
import java.util.List;

public class august_21 {
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("hello from the other side", "they"));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        int n = sentence.length(), i = 0;
        List<String> ans = new ArrayList<>();
        while (i < n) {
            int begin = i;
            while (i < n && sentence.charAt(i) != ' ') {
                i++;
            }
            int end = i;
            ans.add(sentence.substring(begin, end));
            i++;
        }
        int index = -1;
        int len = searchWord.length();
        for (int k = 0; k < ans.size(); k++) {
            int l = ans.get(k).length();
            boolean judge = true;
            if (l < len) {
                continue;
            }
            for (int j = 0; j < len; j++) {
                if (searchWord.charAt(j) != ans.get(k).charAt(j)) {
                    judge = false;
                    break;
                }
            }
            if (judge) {
                index = k + 1;
                break;
            }
        }
        return index;
    }
}
