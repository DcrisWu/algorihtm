package TowardsOffer2.day_14_队列.code_43_往完全二叉树添加节点;

import java.util.LinkedList;
import java.util.Queue;

/**
 * completion time = 2022.10.25
 */
public class CBTInserter {

    static class TreeNode {
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

    private TreeNode root;
    private Queue<TreeNode> queue = new LinkedList<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        TreeNode head = root;
        queue.add(head);
        while (!queue.isEmpty()){
            head = queue.peek();
            if(head.left == null || head.right == null){
                if(head.left != null){
                    queue.add(head.left);
                }
                break;
            }else {
                queue.add(head.left);
                queue.add(head.right);
                queue.poll();
            }
        }
    }

    public int insert(int v) {
        TreeNode peek = queue.peek();
        TreeNode node = new TreeNode(v);
        if(peek.left == null){
            peek.left = node;
        }else {
            peek.right = node;
            queue.poll();
        }
        queue.add(node);
        return peek.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
