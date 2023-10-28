package ByteDance.code_124_二叉树中的最大路径和;

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
 * completion time = 2023.10.28
 */
class Solution {
    private int ans;

    public int maxPathSum(TreeNode root) {
        ans = root.val;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 一定要包含 root
        // left + root | right + root
        int temp = Math.max(left, right) + root.val;
        // just root
        temp = Math.max(temp, root.val);
        temp = Math.max(temp, left + right + root.val);
        ans = Math.max(ans, temp);
        return Math.max(0, Math.max(left, right)) + root.val;
    }
}
