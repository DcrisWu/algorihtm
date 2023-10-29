package ByteDance.code_113_路径总和II;

import java.util.ArrayList;
import java.util.List;

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
    private List<List<Integer>> res;
    private int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        target = targetSum;
        if (root != null) {
            dfs(root, new ArrayList<>(), 0);
        }
        return res;
    }

    void dfs(TreeNode root, List<Integer> prev, int sum) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                prev.add(root.val);
                res.add(new ArrayList<>(prev));
                prev.remove(prev.size() - 1);
            }
            return;
        }
        prev.add(root.val);
        sum += root.val;
        if (root.left != null) {
            dfs(root.left, prev, sum);
        }
        if (root.right != null) {
            dfs(root.right, prev, sum);
        }
        prev.remove(prev.size() - 1);
    }
}
