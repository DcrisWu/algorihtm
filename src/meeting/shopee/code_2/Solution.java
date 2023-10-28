package meeting.shopee.code_2;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public int[] getMostGold(TreeNode nodes) {
        // write code here
        List<Integer> dfs = dfs(nodes);
        int[] res = new int[dfs.size() - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = dfs.get(dfs.size() - i - 1);
        }
        return res;
    }

    // list[0] 表示和 ,list[1:end]表示节点
    List<Integer> dfs(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        if (root == null) {
            return list;
        }
        List<Integer> left = dfs(root.left);
        List<Integer> right = dfs(root.right);
        if (left.get(0) < right.get(0)) {
            right.set(0, right.get(0) + root.val);
            right.add(root.val);
            return right;
        } else {
            left.set(0, left.get(0) + root.val);
            left.add(root.val);
            return left;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t6;
        t3.right = t7;
        for (int i : new Solution().getMostGold(t1)) {
            System.out.println(i);
        }
    }
}
