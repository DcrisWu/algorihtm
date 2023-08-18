package ByteDance.code_236_二叉树的最近公共祖先;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    // boolean[0]表示有p，boolean[1]表示有q
    boolean[] dfs(TreeNode root, TreeNode p, TreeNode q) {
        boolean bp = false, bq = false;
        if (root == null) {
            return new boolean[]{bp, bq};
        }
        boolean[] d1 = dfs(root.left, p, q);
        bp = bp || d1[0];
        bq = bq || d1[1];
        if (bp && bq && ans == null) {
            ans = root;
            return new boolean[]{true, true};
        }
        boolean[] d2 = dfs(root.right, p, q);
        bp = bp || d2[0];
        bq = bq || d2[1];
        if (bp && bq && ans == null) {
            ans = root;
            return new boolean[]{true, true};
        }
        if (root == p) {
            bp = true;
        } else if (root == q) {
            bq = true;
        }
        if (bp && bq && ans == null) {
            ans = root;
            return new boolean[]{true, true};
        }
        return new boolean[]{bp, bq};
    }
}
