package TowardsOffers2.code_7_重建二叉树;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode construct(int[] preorder, int pre_begin, int pre_end, int[] inorder, int in_begin, int in_end) {
        if (pre_end < pre_begin) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[pre_begin]);
        if (pre_end == pre_begin) {
            return treeNode;
        }
        int index = in_begin;
        for (int i = in_begin; i <= in_end; i++) {
            if (inorder[i] == preorder[pre_begin]) {
                index = i;
                break;
            }
        }
        treeNode.left = construct(preorder, pre_begin + 1, pre_begin + index - in_begin, inorder, in_begin, index - 1);
        treeNode.right = construct(preorder, pre_begin + index - in_begin + 1, pre_end, inorder, index + 1, in_end);
        return treeNode;
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
