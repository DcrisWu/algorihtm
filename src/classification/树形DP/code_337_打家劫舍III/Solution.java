package classification.树形DP.code_337_打家劫舍III;

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

/**
 * completion time = 2023.8.4
 */
class Solution {
    public int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0], dfs[1]);
    }

    // int[0]表示选了当前root的最大值，int[1]表示不选root的最大值
    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int choose = root.val + left[1] + right[1];
        int not = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{choose, not};
    }
}
