package classification.树形DP.code_124_二叉树种的最大路径和;

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
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int now = left + right + root.val;
        ans = Math.max(ans, now);
        // 如果当前节点 < 0 ，上一个节点不取这个值
        return Math.max(Math.max(left, right) + root.val, 0);
    }

}
