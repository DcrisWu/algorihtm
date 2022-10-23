package daily;

public class july_21 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        if(root.left != null && (root.left.left != null || root.left.right != null)){
            pruneTree(root.left);
        }
        if(root.right != null && (root.right.left != null || root.right.right != null)){
            pruneTree(root.right);
        }
        if(root.left != null && root.left.left == null && root.left.right == null && root.left.val == 0){
            root.left = null;
        }
        if(root.right != null && root.right.left == null && root.right.right == null && root.right.val == 0){
            root.right = null;
        }
        if(root.left == null &&root.right == null && root.val == 0){
            return null;
        }
        return root;
    }

}
