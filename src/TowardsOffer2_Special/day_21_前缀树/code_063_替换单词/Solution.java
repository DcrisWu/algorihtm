package TowardsOffer2_Special.day_21_前缀树.code_063_替换单词;

import java.util.*;

/**
 * completion time = 2022.11.1
 * 也可以用字典树来做
 */
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        int min = 100;
        for (String s : dictionary) {
            set.add(s);
            min = Math.min(s.length(), min);
        }
        StringBuilder ans = new StringBuilder("");
        int i = 0;
        while (i < sentence.length()) {
            int first = i;
            while (i < sentence.length() && sentence.charAt(i) != ' ') {
                i++;
            }
            String word = sentence.substring(first, i);
            int j = min;
            boolean judge = false;
            while (j <= 100 && j <= word.length()) {
                String root = word.substring(0, j);
                if (set.contains(root)) {
                    ans.append(root);
                    ans.append(' ');
                    judge = true;
                    break;
                } else {
                    j++;
                }
            }
            if (!judge){
                ans.append(word);
                ans.append(' ');
            }
            i++;
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        Solution solution = new Solution();
        System.out.println(solution.replaceWords(dictionary, "the cattle was rattled by the battery"));
    }
}