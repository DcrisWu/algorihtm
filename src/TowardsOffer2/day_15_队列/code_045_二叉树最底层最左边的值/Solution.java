package TowardsOffer2.day_15_队列.code_045_二叉树最底层最左边的值;

import java.util.LinkedList;
import java.util.Queue;

/**
 * completion time = 2022.10.26
 */
public class Solution {

    public class TreeNode {
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

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = root.val;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.peek();
            ans = first.val;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }
}
