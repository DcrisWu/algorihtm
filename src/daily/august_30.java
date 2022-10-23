package daily;

public class august_30 {

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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(val > root.val){
            return new TreeNode(val, root, null);
        }
        TreeNode parent = null;
        TreeNode now = root;
        while (now != null && val < now.val){
            parent = now;
            now = now.right;
        }
        if(now == null){
            parent.right = new TreeNode(val);
        }else {
            parent.right = new TreeNode(val,now,null);
        }
        return root;
    }
}
