package competition.leetcode_weekly.No_355_day_2023_7_23.code_6942_树中可以形成回文的路径数;

import java.util.*;

/**
 * completion time = 2023.7.23
 */
class Solution {
    private long ans;
    private Map<Integer, Integer> count;
    private List<int[]>[] g;

    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();
        // g[i][0]表示父节点 i 到子节点的值，g[i][1]表示父节点 i 到 g[i][0] 的字符，因为只有小写字母，用二进制表示
        g = new ArrayList[n];
        Arrays.setAll(g, g -> new ArrayList<>());
        for (int i = 1; i < parent.size(); i++) {
            Integer p = parent.get(i);
            g[p].add(new int[]{i, 1 << (s.charAt(i) - 'a')});
        }

        ans = 0;
        // count 存的是出现过的从根到某一节点的字符串的次数
        count = new HashMap<>();
        count.put(0, 1);
        dfs(0, 0);
        return ans;
    }

    /**
     *设 v 和 w 的最近公共祖先为 lca，设从根到 x 的路径异或和为 XORx
     * v到 w 的路径可以看成是 v−lca−w 其中 lca 到 v 的路径异或和，等于根到 v 的异或和，再异或上根到 lca 的异或和。（从根到 lca 的边异或了两次，等于 0 抵消掉。）
     * 所以 v−lca−w 异或和为
     *
     * (XORv ⊕ XORlca) ⊕ (XORw ⊕ XORlca) = XORv ⊕ XORw
     * 1. 两数异或和是否为 0？这意味着路径上的每个字母都出现偶数次。
     * 2. 两数异或和是否为 2 的幂？这意味着路径上恰好有个字母出现奇数次，其余字母出现偶数次。
     * 3. XORv = 0 或者 XORv 为 222 的幂，表示从根到 v 的路径符合要求，我们可以异或上一条「空路径」对应的异或值，即 0，就转换成了上面两数异或和的情况。
     */
    void dfs(int to, int xor) {
        for (int[] pair : g[to]) {
            int val = pair[1];
            int x = xor ^ val;
            // 如果曾经就出现过相同的字符串，就直接相加
            ans += count.getOrDefault(x, 0);
            for (int i = 0; i < 26; i++) {
                // a ^ b == 2的幂 ==> a ^ 2的幂 == b
                // 查找能够XOR之后为 2的幂的次数，并加到ans
                ans += count.getOrDefault(x ^ (1 << i), 0);
            }
            count.put(x, count.getOrDefault(x, 0) + 1);
            dfs(pair[0], x);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(2);
        System.out.println(new Solution().countPalindromePaths(list, "acaabc"));
    }
}
