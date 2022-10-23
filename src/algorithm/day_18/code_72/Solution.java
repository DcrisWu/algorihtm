package algorithm.day_18.code_72;

/**
 * completion time = 2022.9.27
 */
public class Solution {
    /**
     * @param word1 A
     * @param word2 B
     * 对A、B都可以进行的添加、删除、修改操作 == 对A末尾进行添加、对B末尾进行添加、对B末尾进行修改
     * 那么 horse -> ros 相当于
     * 1、如 horse -> ro 已知，设为 a 个步骤，对 ro 末尾进行添加，a+1
     * 2、如 hors -> ros 已知，设为 b 个步骤，对 hors 末尾进行添加,b+1
     * 3、如 hors -> ro 已知，设为 c 个步骤，将 horse 末尾修改为 horss，为c+1，如果两个单词的最后一页个字符相等，则为c
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                int a = dp[i - 1][j] + 1;
                int b = dp[i][j - 1] + 1;
                int c;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    c = dp[i - 1][j - 1];
                } else {
                    c = dp[i - 1][j - 1] + 1;
                }
                int min = Math.min(a, b);
                min = Math.min(min, c);
                dp[i][j] = min;
            }
        }
        return dp[m][n];
    }
}
