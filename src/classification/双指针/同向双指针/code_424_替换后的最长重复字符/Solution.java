package classification.双指针.同向双指针.code_424_替换后的最长重复字符;

class Solution {
    /**
     * 本题的关键是，记录滑动窗口中一个字符出现过数量的最大值historicalMax
     * 滑动窗口的长度 - historicalMax <= k，就是符合条件的，符合条件的时候，右指针移动
     * 如果 滑动窗口的长度 - historicalMax > k，那说明当前窗口不符合题意，但是我们不需要把左指针移动到符合题意的位置，只需要左指针向右移动一位
     * 换而言之，我们不需要滑动窗口内的字符串总是符合要求，我们只需要记录符合要求的字符串的最大长度
     * 如果移动后滑动窗口一直不符合要求，那么滑动窗口的长度就会等于移动前的滑动窗口的长度，最后直接返回这个长度即可
     * 如果后面有一个更长的符合要求的滑动窗口，就不需要移动左指针，移动右指针可以
     * 想要找到更长的滑动窗口，就是需要找到更大的historicalMax，只需要右指针移动的时候，尝试更新historicalMax
     */
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int historicalMax = 0; // 表示滑动窗口中同一字符出现过的最大次数
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            count[c - 'A'] += 1;
            historicalMax = Math.max(historicalMax, count[c - 'A']);
            if (j - i + 1 - historicalMax > k) {
                count[s.charAt(i) - 'A'] -= 1;
                i++;
            }
        }
        return s.length() - i;
    }
}
