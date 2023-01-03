package daily.year_2023.January.day_3_code_2042_检查句子中的数字是否递增;

class Solution {
    public boolean areNumbersAscending(String s) {
        String[] split = s.split(" ");
        int pre = -1;
        for (String s1 : split) {
            boolean judge = true;
            for (int i = 0; i < s1.length(); i++) {
                if (!Character.isDigit(s1.charAt(i))) {
                    judge = false;
                    break;
                }
            }
            if (judge) {
                int i = Integer.parseInt(s1);
                if (i <= pre) {
                    return false;
                } else {
                    pre = i;
                }
            }
        }
        return true;
    }
}