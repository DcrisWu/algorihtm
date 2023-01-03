package TowardsOffers2.code_54_二叉搜索树的第k大节点;

class Solution {
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k,0);
        return res;
    }

    int res = 0;

    int dfs(TreeNode root, int k, int pre) {
        if (root == null) {
            return pre;
        }
        int right = dfs(root.right, k, pre);
        if (right == k) {
            return k;
        }
        if (right + 1 == k) {
            res = root.val;
            return k;
        }
        return dfs(root.left, k, right + 1);
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
