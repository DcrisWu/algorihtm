package ByteDance.code_662_二叉树最大宽度;

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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> t = new ArrayDeque<>();
        Queue<Integer> q = new ArrayDeque<>();
        t.add(root);
        q.add(1);
        int ans = 1;
        int begin = -1;
        while (!t.isEmpty()) {
            int size = t.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                TreeNode node = t.poll();
                if (node.left != null) {
                    q.add(poll * 2);
                    t.add(node.left);
                }
                if (node.right != null) {
                    q.add(poll * 2 + 1);
                    t.add(node.right);
                }
                if (begin == -1) {
                    begin = poll;
                } else {
                    ans = Math.max(ans, poll - begin + 1);
                }
            }
            begin = -1;
        }
        return ans;
    }
}