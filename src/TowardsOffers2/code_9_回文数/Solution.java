package TowardsOffers2.code_9_回文数;

class Solution {
    public boolean isPalindrome(int x) {
        String temp = String.valueOf(x);
        int i = 0;
        int j = temp.length() - 1;
        while (i <= j) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
