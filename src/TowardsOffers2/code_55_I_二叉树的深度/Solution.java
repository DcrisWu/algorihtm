package TowardsOffers2.code_55_I_二叉树的深度;

class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
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
