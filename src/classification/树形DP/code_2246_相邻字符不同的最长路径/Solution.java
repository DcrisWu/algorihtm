package classification.树形DP.code_2246_相邻字符不同的最长路径;

import java.util.ArrayList;

class Solution {

    private ArrayList<Integer>[] child;
    private String s;
    private int ans;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.ans = 0;
        this.child = new ArrayList[n];
        for (int i = 1; i < n; i++) {
            int p = parent[i];
            if (child[p] == null) {
                child[p] = new ArrayList<>();
            }
            child[p].add(i);
        }
        dfs(0);
        return ans + 1;
    }

    int dfs(int root) {
        if (child[root] == null) {
            return 0;
        }
        int first = -1, second = -1;
        int now = 0;
        for (Integer kid : child[root]) {
            // 相邻节点的节点不能为空
            int temp = dfs(kid);
            if (s.charAt(root) != s.charAt(kid)) {
                if (temp >= first) {
                    second = first;
                    first = temp;
                } else if (temp > second) {
                    second = temp;
                }
                if (first != -1 && second != -1) {
                    now = Math.max(now, first + second + 2);
                } else if (first != -1) {
                    now = Math.max(now, first + 1);
                }
            }
        }
        ans = Math.max(ans, now);
        return first + 1;
    }

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2};
        String s = "abacbe";
        System.out.println(new Solution().longestPath(parent, s));
    }
}
