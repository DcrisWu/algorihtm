package daily.year_2026.January.day_7_code_1339_分裂二叉树的最大乘积;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private long res = Integer.MIN_VALUE;
    private int sum;

    public int maxProduct(TreeNode root) {
        this.sum = dfs(root);
        long mod = (long) (1e9 + 7);
        count(root);
        return (int) (res % mod);
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + dfs(root.left) + dfs(root.right);
    }

    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int now = root.val + count(root.left) + count(root.right);
        long count = (long) now * (sum - now);
        res = Math.max(res, count);
        return now;
    }
}