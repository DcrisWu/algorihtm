package daily.year_2022.July;


import java.util.*;

public class july_31 {

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

    public int maxLevelSum(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.putIfAbsent(root, 1);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head.left != null) {
                queue.add(head.left);
                map.putIfAbsent(head.left, map.get(head) + 1);
            }
            if (head.right != null) {
                queue.add(head.right);
                map.putIfAbsent(head.right, map.get(head) + 1);
            }
        }
        int n = 0;
        for (Integer value : map.values()) {
            n = Math.max(n, value);
        }
        int[] arr = new int[n];
        for (TreeNode treeNode : map.keySet()) {
            arr[map.get(treeNode) - 1] += treeNode.val;
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[ans]) {
                ans = i;
            }
        }
        return ans+1;
    }
}
