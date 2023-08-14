package classification.树.code_222_完全二叉树的节点个数;

class TreeNode {
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

/**
 * completion time = 2023.8.14
 *
 * 完全二叉树求节点数量，利用完全二叉树的特性，再根据二进制去查找该节点是否存在
 */
class Solution {
    public int countNodes(TreeNode root) {
        int depth = getDepth(root);
        int l = (int) Math.pow(2, depth - 1);
        int r = (int) (Math.pow(2, depth) - 1);
        int ans = l;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(root, depth - 1, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getDepth(root.left);
    }

    // 完全二叉树的特性
    // 从第0层开始向下数，对于第i个节点，从它的二进制中从左到右的第 2 个数开始向右遍历
    // 如果是0，表示向左走，1表示向右走
    // 例如：5的二进制是101，第一次遍历是0，那就是从1往左走，走到2，第二次遍历是1，就是从2往右走，就是5.总共就遍历两次
    // 如果 node != null，说明完全二叉树中存在5这个节点，否则不存在5这个节点
    boolean check(TreeNode root, int level, int target) {
        TreeNode node = root;
        for (int i = level - 1; i >= 0; i--) {
            if (node == null) {
                return false;
            }
            if (((1 << i) & target) != 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node != null;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        System.out.println(new Solution().countNodes(n1));
    }
}
