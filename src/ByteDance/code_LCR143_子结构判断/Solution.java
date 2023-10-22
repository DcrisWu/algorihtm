package ByteDance.code_LCR143_子结构判断;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (isContain(A, B)) {
            return true;
        }
        if (isSubStructure(A.left, B)) {
            return true;
        }
        return isSubStructure(A.right, B);
    }

    boolean isContain(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        boolean left = isContain(A.left, B.left);
        if (!left) {
            return false;
        }
        return isContain(A.right, B.right);
    }
}
