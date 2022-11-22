package competition.day_2022_9_18.code_6182;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static class TreeNode {
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

    public TreeNode reverseOddLevels(TreeNode root) {
        int mark = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int[] temp = new int[0];
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (mark % 2 == 0) {
                temp = new int[size * 2];
                for (int i = 0; i < size; i++) {
                    TreeNode head = queue.poll();
                    if (head.left != null) {
                        queue.add(head.left);
                        temp[i * 2] = head.left.val;
                    }
                    if (head.right != null) {
                        queue.add(head.right);
                        temp[i * 2 + 1] = head.right.val;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode head = queue.poll();
                    head.val = temp[size - i - 1];
                    if (head.left != null) {
                        queue.add(head.left);
                    }
                    if (head.right != null) {
                        queue.add(head.right);
                    }
                }
            }
            mark++;
        }
        return root;
    }

}
