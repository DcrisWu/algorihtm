package daily;

import java.util.*;

public class august_22 {

    public class TreeNode {
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

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(10);
    }

    private String[][] ans;
    private int m, n, height;

    public List<List<String>> printTree(TreeNode root) {
        height = deep(root);
        m = height + 1;
        n = (int) (Math.pow(2, m) - 1);
        ans = new String[m][n];
        for (String[] an : ans) {
            Arrays.fill(an,"");
        }
        ans[0][(n-1)/2] = String.valueOf(root.val);
        construct(root,0,(n-1)/2);
        List<List<String>> res = new ArrayList<>();
        for (String[] an : ans) {
            res.add(Arrays.stream(an).toList());
        }
        return res;
    }

    public void construct(TreeNode root, int row, int column) {
        if (root.left != null) {
            int r = row + 1;
            int c = column - (int) Math.pow(2, height - row - 1);
            ans[r][c] = String.valueOf(root.left.val);
            construct(root.left, r, c);
        }
        if (root.right != null) {
            int r = row + 1;
            int c = (int) (column + Math.pow(2, height - row - 1));
            ans[r][c] = String.valueOf(root.right.val);
            construct(root.right, r, c);
        }
    }


    public int deep(TreeNode root) {
        if (root.left != null && root.right != null) {
            return Math.max(deep(root.left), deep(root.right)) + 1;
        } else if (root.left != null) {
            return deep(root.left) + 1;
        } else if (root.right != null) {
            return deep(root.right) + 1;
        } else {
            return 0;
        }
    }

}
