package TowardsOffer.day_7_搜索与回溯算法_简单.code_27_二叉树的镜像;

/**
 * completion time = 2022.11.26
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);
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