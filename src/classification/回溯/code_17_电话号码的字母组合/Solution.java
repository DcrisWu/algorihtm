package classification.回溯.code_17_电话号码的字母组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2023.9.8
 */
class Solution {

    private List<Character>[] dig;
    private List<String> res;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return new ArrayList<>();
        }
        dig = new ArrayList[10];
        Arrays.setAll(dig, e -> new ArrayList<>());
        dig[2].addAll(List.of(new Character[]{'a', 'b', 'c'}));
        dig[3].addAll(List.of(new Character[]{'d', 'e', 'f'}));
        dig[4].addAll(List.of(new Character[]{'g', 'h', 'i'}));
        dig[5].addAll(List.of(new Character[]{'j', 'k', 'l'}));
        dig[6].addAll(List.of(new Character[]{'m', 'n', 'o'}));
        dig[7].addAll(List.of(new Character[]{'p', 'q', 'r', 's'}));
        dig[8].addAll(List.of(new Character[]{'t', 'u', 'v'}));
        dig[9].addAll(List.of(new Character[]{'w', 'x', 'y', 'z'}));
        res = new ArrayList<>();
        recursive(new StringBuilder(), digits, 0);
        return res;
    }

    void recursive(StringBuilder have, String digits, int idx) {
        if (have.length() == digits.length()) {
            res.add(have.toString());
        }
        for (int i = idx; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            for (Character c : dig[num]) {
                have.append(c);
                recursive(have, digits, i + 1);
                have.delete(have.length() - 1, have.length());
            }
        }
    }
}
