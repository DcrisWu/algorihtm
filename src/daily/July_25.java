package daily;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class July_25 {
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

    private Queue<TreeNode> candidate;
    private TreeNode root;

    public July_25(TreeNode root) {
        this.root = root;
        candidate = new ArrayDeque<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //表示头结点，移除头结点
            TreeNode head = queue.poll();
            //添加左节点
            if (head.left != null) {
//                candidate.add(head.left);
                queue.add(head.left);
            }
            //添加右节点
            if (head.right != null) {
//                ans.add(head.right);
                queue.add(head.right);
            }
            //如果该节点的左右节点存在一个为空，就是候选节点
            if (head.left == null || head.right == null) {
                candidate.add(head);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode parent = candidate.peek();
        if (parent.left == null) {
            parent.left = child;
        }else {
            parent.right = child;
            candidate.poll();
        }
        candidate.add(child);
        return parent.val;

    }

    public TreeNode get_root() {
        return root;
    }
}


