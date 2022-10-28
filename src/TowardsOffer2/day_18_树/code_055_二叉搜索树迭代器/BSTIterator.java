package TowardsOffer2.day_18_树.code_055_二叉搜索树迭代器;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * completion time = 2022.10.28
 */
class BSTIterator {

    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        findLeft(root);
    }

    public int next() {
        TreeNode re = stack.pop();
        findLeft(re.right);
        return re.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    void findLeft(TreeNode root){
        if(root == null){
            return;
        }
        stack.push(root);
        findLeft(root.left);
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
