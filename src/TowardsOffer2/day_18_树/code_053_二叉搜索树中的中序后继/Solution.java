package TowardsOffer2.day_18_树.code_053_二叉搜索树中的中序后继;

/**
 * completion time = 2022.10.28
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        TreeNode left = inorderSuccessor(root.left, p);
        if(left != null){
            return left;
        }
        if(root.val > p.val){
            return root;
        }
        TreeNode right = inorderSuccessor(root.right, p);
        if(right != null){
            return right;
        }
        return null;
    }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
