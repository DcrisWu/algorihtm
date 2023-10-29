package ByteDance.code_230_二叉搜索树中第K小的元素;

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
    private int ans = -1;
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root, 0);
        return ans;
    }

    // <= root.val 的个数，dfs是用来遍历个数，pre表示 root 节点之前的节点个数
    int dfs(TreeNode root, int pre) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, pre);
        if (ans != -1) {
            return k;
        }
        if (left + pre + 1 == k) {
            ans = root.val;
        }
        int right = dfs(root.right, pre + left + 1);
        return left + right + 1;
    }
}