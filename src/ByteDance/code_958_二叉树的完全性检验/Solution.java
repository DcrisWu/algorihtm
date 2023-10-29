package ByteDance.code_958_二叉树的完全性检验;

import java.util.ArrayDeque;
import java.util.Queue;

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

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> t = new ArrayDeque<>();
        boolean flag = true;
        t.add(root);
        while (!t.isEmpty()) {
            int size = t.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = t.poll();
                if (node.left != null) {
                    // 如果前面已经出现了空缺的子树，而当前的节点存在子树，就直接返回false
                    if (!flag) {
                        return false;
                    }
                    t.add(node.left);
                } else {
                    // 当出现左子树 / 右子树为 null 时候，这一层后面的节点，就不允许存在 左子树 和 右子树
                    flag = false;
                }
                if (node.right != null) {
                    if (!flag) {
                        return false;
                    }
                    t.add(node.right);
                } else {
                    flag = false;
                }
            }
        }
        return true;
    }
}
