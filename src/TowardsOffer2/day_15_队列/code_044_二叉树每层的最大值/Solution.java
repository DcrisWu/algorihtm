package TowardsOffer2.day_15_队列.code_044_二叉树每层的最大值;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * completion time = 2022.10.26
 */
public class Solution {

    static class TreeNode {
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

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int temp = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                TreeNode head = queue.poll();
                temp = Math.max(temp, head.val);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
