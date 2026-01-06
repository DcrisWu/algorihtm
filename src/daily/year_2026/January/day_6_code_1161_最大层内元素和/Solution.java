package daily.year_2026.January.day_6_code_1161_最大层内元素和;

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

class Solution {
    public int maxLevelSum(TreeNode root) {
        int res = 1;
        int max = Integer.MIN_VALUE;
        int level = 1;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                sum += poll.val;
                if (poll.left != null){
                    q.add(poll.left);
                }
                if (poll.right != null){
                    q.add(poll.right);
                }
            }
            if (sum > max){
                max = sum;
                res = level;
            }
            level++;
        }
        return res;
    }
}