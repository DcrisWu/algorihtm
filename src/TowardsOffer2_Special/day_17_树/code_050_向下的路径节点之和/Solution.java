package TowardsOffer2_Special.day_17_树.code_050_向下的路径节点之和;

import java.util.HashMap;
import java.util.Map;

/**
 * completion time = 2022.10.27
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Map<Long, Integer> map = new HashMap<>();
        return dfs(root, 0, 0L, targetSum, map);
    }

    Integer dfs(TreeNode root, int sum, Long preSum, int target, Map<Long, Integer> map) {
        preSum += root.val;
        if (preSum == target) {
            sum += 1;
        }
        sum += map.getOrDefault(preSum - target, 0);
        Map<Long, Integer> next = new HashMap<>(map);
        next.put(preSum, map.getOrDefault(preSum, 0) + 1);
        if (root.left != null) {
            sum = dfs(root.left, sum, preSum, target, next);
        }
        if (root.right != null) {
            sum = dfs(root.right, sum, preSum, target, next);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(-2);
        TreeNode t7 = new TreeNode(1);
        TreeNode t8 = new TreeNode(-3);
        TreeNode t9 = new TreeNode(11);
        t1.left=t2;
        t1.right=t8;
        t2.left = t3;
        t2.right = t4;
        t3.left=t5;
        t3.right=t6;
        t4.right=t7;
        t8.right=t9;
        Solution solution = new Solution();
        System.out.println(solution.pathSum(t1,8));
    }
}

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

/*
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
*/