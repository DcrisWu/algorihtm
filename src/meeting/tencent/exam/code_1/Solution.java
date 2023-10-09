package meeting.tencent.exam.code_1;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    private int ans = 0;

    public int pathNumber(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0, 0);
        return ans;
    }

    void dfs(TreeNode root, int one, int zero) {
        if (root.val == 1) {
            one += 1;
        } else {
            zero += 1;
        }
        if (root.left == null && root.right == null) {

            if (one == zero + 1) {
                ans++;
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, one, zero);
        }
        if (root.right != null) {
            dfs(root.right, one, zero);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        System.out.println(new Solution().pathNumber(n1));

    }
}