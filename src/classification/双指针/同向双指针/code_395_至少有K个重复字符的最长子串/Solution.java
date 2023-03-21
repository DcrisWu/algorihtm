package classification.双指针.同向双指针.code_395_至少有K个重复字符的最长子串;

class Solution {
    /**
     * 遇到寻找满足条件的最长子串，首先会想到使用滑动窗口，但这道题如果直接在原有的数据上直接进行滑动窗口是很难的
     * 滑动窗口和二分法最重要的是利用了“二段性质”，对于双指针来说：就是在某个条件下 i ,j 只有一个指针是可以移动的，移动的方向是确定的
     * 但本道题没办法直接使用双指针，因为我们不知道什么时候移动哪个指针，往哪个方向移动
     * 但是我们注意到，题目限定了最多只有26个小写字母，我们可以限定 字符串子串 中的包含的字符的最大数量，遍历26次，还是这一步是O(1)
     * 此时，数据就具有 二段性质：
     * 1. 当 j 右移时候，子串中的字符数量只会增大或者不变
     * 2. 当 i 右移时候，子串中的字符数量只会减少或者不变
     * tot：滑动窗口中字符的数量，sum：滑动窗口中出现次数 >= k的字符的数量，p：滑动窗口最多出现 p 个字符
     * 在指针 j 右移时候，每遇到一个新字符：tot++。某一个字符出现的次数 >= k：sum++。
     * 当tot > p时候，就右移左指针 i，直到 tot <= p，移动过程中更新tot和sum
     * 如果移动完之后 tot == sum，说明滑动窗口内的字符都符合条件，此时取最大值作为 ans
     * 最后遍历26遍就可以了
     */
    public int longestSubstring(String s, int k) {
        int ans = 0;
        for (int p = 1; p <= 26; p++) {
            int[] count = new int[26];
            for (int i = 0, j = 0, tot = 0, sum = 0; j < s.length(); j++) {
                char rc = s.charAt(j);
                count[rc - 'a'] += 1;
                if (count[rc - 'a'] == 1) {
                    tot++;
                }
                if (count[rc - 'a'] == k) {
                    sum++;
                }
                while (tot > p) {
                    char lc = s.charAt(i++);
                    count[lc - 'a'] -= 1;
                    if (count[lc - 'a'] == 0) {
                        tot -= 1;
                    }
                    if (count[lc - 'a'] == k - 1) {
                        sum -= 1;
                    }
                }
                if (tot == sum) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubstring("aaabb", 3));
    }
}
