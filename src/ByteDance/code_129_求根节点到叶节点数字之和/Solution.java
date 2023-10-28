package ByteDance.code_129_求根节点到叶节点数字之和;

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
    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode root, int pre) {
        if (root.left == null && root.right == null) {
            ans += pre * 10 + root.val;
            return;
        }
        int now = pre * 10 + root.val;
        if (root.left != null) {
            dfs(root.left, now);
        }
        if (root.right != null) {
            dfs(root.right, now);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(new Solution().sumNumbers(t1));
    }
}
