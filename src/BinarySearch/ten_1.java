package BinarySearch;

/**
 * code_222
 */
public class ten_1 {

    public static class TreeNode {
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

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int num = 1;
        TreeNode head = root;
        while (head != null) {
            if (head.left == null && head.right == null) {
                break;
            }
            int l = dept(head.left), r = dept(head.right);
            if (l > r) {
                head = head.left;
                num *= 2;
            } else {
                head = head.right;
                num = num * 2 + 1;
            }
        }
        return num;
    }

    public int dept(TreeNode root) {
        if (root == null) {
            return -1;
        } else if (root.left == null && root.right == null) {
            return 0;
        }
        return Math.max(dept(root.left), dept(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        ten_1 ten_1 = new ten_1();
        System.out.println(ten_1.countNodes(root));
    }
}
