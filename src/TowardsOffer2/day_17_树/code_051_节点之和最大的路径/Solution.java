package TowardsOffer2.day_17_树.code_051_节点之和最大的路径;

/**
 * completion time = 2022.10.27
 */
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

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, Math.max(root.val, Math.max(Math.max(left + root.val, right + root.val), left + right + root.val)));

        return Math.max(root.val, Math.max(left, right) + root.val);
    }


}
