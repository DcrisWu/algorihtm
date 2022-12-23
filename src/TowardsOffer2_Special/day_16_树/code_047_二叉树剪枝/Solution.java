package TowardsOffer2_Special.day_16_树.code_047_二叉树剪枝;

import java.util.*;

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

    public TreeNode pruneTree(TreeNode root) {
        if (!dfs(root)) {
            return null;
        }
        return root;
    }

    public boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        if (root.val == 0 && !left && !right) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        /*TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(1);

        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        Solution solution = new Solution();
        solution.pruneTree(treeNode1);*/

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>(4);
        System.out.println(list.size());
//        list.set(1,1);
//        list.set(2,2);
//        list.set(3,3);
//        System.out.println(list);

//        System.out.println(arr.toString());
    }
}
