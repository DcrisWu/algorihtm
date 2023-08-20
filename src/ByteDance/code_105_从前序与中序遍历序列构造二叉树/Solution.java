package ByteDance.code_105_从前序与中序遍历序列构造二叉树;

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
 * completion time = 2023.8.19
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode dfs(int[] preorder, int[] inorder, int il, int ir, int pl, int pr) {
        if (il > ir){
            return null;
        }
        if (il == ir) {
            return new TreeNode(inorder[il]);
        }
        int mid = il;
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == preorder[pl]) {
                mid = i;
                break;
            }
        }
        int llen = mid - il;
        TreeNode root = new TreeNode(inorder[mid]);
        root.left = dfs(preorder, inorder, il, mid - 1, pl + 1, pl + llen);
        root.right = dfs(preorder, inorder, mid + 1, ir, pl + llen + 1, pr);
        return root;
    }

    public static void main(String[] args) {
        int[] p = {1, 2};
        int[] i = {2, 1};
        TreeNode node = new Solution().buildTree(p, i);
    }
}
