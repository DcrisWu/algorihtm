package ByteDance.code_98_验证二叉搜索树;

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

    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 二叉树需要满足条件 root.val < high && root.val > low
    // 并且是每一个节点都需要满足
    boolean check(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        // 任意一个节点不满足root.val < high && root.val > low，就直接返回false
        if (root.val <= low || root.val >= high) {
            return false;
        }
        // 对于左节点来说，high变小了，变成root.val
        boolean left = check(root.left, low, root.val);
        // 对于右节点来说，low变大了，变成了root.val
        boolean right = check(root.right, root.val, high);
        return left & right;
    }


}
