package TowardsOffer2_Special.day_16_树.code_049_从根节点到叶节点的路径数字之和;

/**
 * completion time = 2022.10.27
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0, 0);

    }

    Integer dfs(TreeNode root, int val, int sum) {
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += val;
        } else {
            if (root.left != null) {
                sum = dfs(root.left, val, sum);
            }
            if (root.right != null) {
                sum = dfs(root.right, val,sum);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(0);
        t1.left=t2;
        t1.right=t5;
        t2.left=t3;
        t2.right=t4;
        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(t1));
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