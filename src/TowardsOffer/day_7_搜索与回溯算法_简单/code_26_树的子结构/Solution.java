package TowardsOffer.day_7_搜索与回溯算法_简单.code_26_树的子结构;

/**
 * completion time = 2022.11.26
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null){
            return false;
        }
        return dfs(A, B);
    }

    boolean dfs(TreeNode father, TreeNode son) {
        if (check(father, son)) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        if (father != null) {
            left = dfs(father.left, son);
            right = dfs(father.right, son);
        }
        return left || right;
    }

    boolean check(TreeNode father, TreeNode son) {
        // 如果son == null，那就直接返回true
        if (son == null) {
            return true;
        }
        // 如果son != null，但father == null，就返回false
        if (father == null) {
            return false;
        }
        // 当两个都不为null时候
        // 如果两个值不一样，直接返回false
        if (father.val != son.val) {
            return false;
        }
        boolean left = check(father.left, son.left);
        boolean right = check(father.right, son.right);
        return left && right;
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