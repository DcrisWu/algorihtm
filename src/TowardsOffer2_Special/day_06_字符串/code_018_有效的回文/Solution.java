package TowardsOffer2_Special.day_06_字符串.code_018_有效的回文;

/**
 * completion time = 2022.10.19
 */
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder temp = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (Character.isLetter(now)) {
                temp.append(Character.toLowerCase(now));
            } else if(Character.isDigit(now)){
                temp.append(now);
            }
        }
        int r = temp.length() / 2;
        int l = temp.length() % 2 == 0 ? r - 1 : r;
        while (l >= 0 && r < temp.length()) {
            if (temp.charAt(l) != temp.charAt(r)) {
                return false;
            }
            l--;
            r++;
        }
        return true;
    }
}