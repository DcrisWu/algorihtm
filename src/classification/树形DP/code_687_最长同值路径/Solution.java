package classification.树形DP.code_687_最长同值路径;

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
    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int now = 0;
        int res = 0;
        if (root.left != null && root.val == root.left.val) {
            now += left + 1;
            res = left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            now += right + 1;
            res = Math.max(res, right + 1);
        }
        ans = Math.max(ans, now);
        return res;
    }
}
