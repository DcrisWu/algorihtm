package TowardsOffers2.code_68_II_二叉树的最近公共祖先;

class Solution {
    private TreeNode parent = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return parent;
    }

    // 0表示root为根的树不包含 p 也不包含 q
    // 1表示已经包含 p
    // 2表示已经包含 q
    // 3表示p和q都包含了
    int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        if (left == 3 || right == 3) {
            return 3;
        }
        if ((left == 1 && right == 2) || (left == 2 && right == 1)) {
            parent = root;
            return 3;
        }
        int now = 0;
        if (root == p) {
            now = 1;
        }
        if (root == q) {
            now = 2;
        }
        if (now == 1 && (left == 2 || right == 2)) {
            parent = root;
            return 3;
        }
        if (now == 2 && (left == 1 || right == 1)) {
            parent = root;
            return 3;
        }
        return Math.max(now, Math.max(left, right));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
