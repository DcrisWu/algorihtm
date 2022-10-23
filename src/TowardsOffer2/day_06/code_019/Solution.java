package TowardsOffer2.day_06.code_019;

/**
 * completion time = 2022.10.19
 */
class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() <= 2) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        boolean judge = true;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                int l1 = l;
                int r1 = r - 1;
                while (l1 <= r1) {
                    if (s.charAt(l1) == s.charAt(r1)) {
                        l1++;
                        r1--;
                    } else {
                        judge = false;
                        break;
                    }
                }
                if (!judge) {
                    int l2 = l + 1;
                    int r2 = r;
                    while (l2 <= r2) {
                        if (s.charAt(l2) == s.charAt(r2)) {
                            l2++;
                            r2--;
                        } else {
                            break;
                        }
                    }
                    if (l2 > r2) {
                        judge = true;
                    }
                }
                break;
            }
        }
        return judge;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("abc"));
    }
}