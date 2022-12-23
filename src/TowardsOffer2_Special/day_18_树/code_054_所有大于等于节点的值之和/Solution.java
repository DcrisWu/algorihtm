package TowardsOffer2_Special.day_18_树.code_054_所有大于等于节点的值之和;

/**
 * completion time = 2022.10.28
 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        dfs(root,0);
        return root;
    }

    int dfs(TreeNode root,int preSum){
        if(root == null){
            return preSum;
        }
        preSum = dfs(root.right, preSum);
        preSum += root.val;
        root.val = preSum;
        System.out.println(root.val);
        preSum = dfs(root.left,preSum);
        return preSum;
    }
}

class TreeNode {
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