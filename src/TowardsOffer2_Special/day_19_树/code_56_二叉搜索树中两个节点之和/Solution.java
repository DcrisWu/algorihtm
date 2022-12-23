package TowardsOffer2_Special.day_19_树.code_56_二叉搜索树中两个节点之和;

import java.util.HashSet;
import java.util.Set;

/**
 * completion time = 2022.10.30
 */
class Solution {

    private Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        if(set.contains(k- root.val)){
            return true;
        }
        set.add(root.val);
        if(findTarget(root.left,k)){
            return true;
        }
        return findTarget(root.right, k);
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
