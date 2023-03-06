package daily.year_2023.March.code_1653_使字符串平衡的最少删除次数;

/**
 * completion time = 2023.3.6
 */
class Solution {
    public int minimumDeletions(String s) {
        int leftb = 0, righta = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                righta++;
            }
        }
        int ans = righta;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                righta -= 1;
            } else {
                leftb += 1;
            }
            ans = Math.min(ans, leftb + righta);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDeletions("aababbab"));
    }
}
