package algorithm.day_7.code_572;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * completion time = 2022.9.19
 */
public class Solution {
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode head = queue.poll();
            if(check(head,subRoot)){
                return true;
            }
            if(head.left!=null){
                queue.add(head.left);
            }
            if(head.right!=null){
                queue.add(head.right);
            }
        }
        return false;
    }

    public boolean check(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null || root.val != subRoot.val){
            return false;
        }
        boolean judge1 = check(root.left,subRoot.left);
        boolean judge2 = check(root.right,subRoot.right);
        return judge1 && judge2;
    }
}
