package TowardsOffers2.code_34_二叉树中和为某一值的路径;


import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null){
            return ans;
        }
        List<Integer> init = new ArrayList<>();
        backTrace(init, 0, root, target);
        return ans;
    }

    void backTrace(List<Integer> temp, int preSum, TreeNode root, int target) {
        // 是叶子节点，并且之前的和加上根的值等于target，就加入到ans
        if (root.left == null && root.right == null) {
            if (root.val + preSum == target) {
                temp.add(root.val);
                ans.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
        } else {
            temp.add(root.val);
            if (root.left != null) {
                backTrace(temp, preSum + root.val, root.left, target);
            }
            if (root.right != null) {
                backTrace(temp, preSum + root.val, root.right, target);
            }
            temp.remove(temp.size() - 1);
        }
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