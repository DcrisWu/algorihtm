package daily.year_2023.March.day_9_code_2379_得到K个黑块的最少涂色次数;

/**
 * completion time = 2023.3.9
 */
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                ans++;
            }
        }
        int need = ans;
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') {
                need--;
            }
            if (blocks.charAt(i) == 'W') {
                need++;
            }
            ans = Math.min(ans, need);
        }
        return ans;
    }
}
