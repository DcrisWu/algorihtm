package ByteDance.code_114_二叉树展开为链表;

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
 * completion time = 2023.10.29
 */
class Solution {
    private TreeNode res = new TreeNode();
    private TreeNode pre = res;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
    }

    // 线序遍历
    void dfs(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        pre.right = root;
        pre = root;
        if (left != null) {
            dfs(left);
        }
        if (right != null) {
            dfs(right);
        }
    }
}
