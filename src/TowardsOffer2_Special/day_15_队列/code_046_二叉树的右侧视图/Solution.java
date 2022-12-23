package TowardsOffer2_Special.day_15_队列.code_046_二叉树的右侧视图;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * completion time = 2022.10.26
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ans = new LinkedList<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len - 1; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            TreeNode last = queue.poll();
            ans.add(last.val);
            if (last.left != null) {
                queue.add(last.left);
            }
            if (last.right != null) {
                queue.add(last.right);
            }
        }
        return ans;
    }

}
