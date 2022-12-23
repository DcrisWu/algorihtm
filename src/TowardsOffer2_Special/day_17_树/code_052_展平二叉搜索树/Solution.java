package TowardsOffer2_Special.day_17_树.code_052_展平二叉搜索树;

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
 * completion time = 2022.10.27
 */
class Solution {
    private TreeNode head = null;
    private TreeNode tail = null;

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return head;
    }

    void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(head == null){
            head = root;
        }else {
            tail.right = root;
        }
        tail = root;
        root.left = null;
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(-2);
        TreeNode t7 = new TreeNode(1);
        TreeNode t8 = new TreeNode(-3);
        TreeNode t9 = new TreeNode(11);
        t1.left=t2;
        t1.right=t8;
        t2.left = t3;
        t2.right = t4;
        t3.left=t5;
        t3.right=t6;
        t4.right=t7;
        t8.right=t9;
        Solution solution = new Solution();
        System.out.println(solution.increasingBST(t1));
    }
}
