package BasicCoding.day_16.code_173;

import java.util.ArrayList;
import java.util.List;

/**
 * completion time = 2022.10.9
 */
public class BSTIterator {

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

    private List<Integer> ans;
    private int index = 0;

    public BSTIterator(TreeNode root) {
        ans = new ArrayList<>();
        recursion(root);
    }

    public void recursion(TreeNode root) {
        if (root.left != null) {
            recursion(root.left);
        }
        ans.add(root.val);
        if (root.right != null) {
            recursion(root.right);
        }
    }

    public int next() {
        return ans.get(index++);
    }

    public boolean hasNext() {
        return index < ans.size();
    }
}
