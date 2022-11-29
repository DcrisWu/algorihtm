package daily.year_2022.August;

import java.util.*;

public class august_17 {
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

    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int sum = 0;
            while (!queue.isEmpty()) {
                sum = 0;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode head = queue.poll();
                    sum += head.val;
                    if (head.left != null) {
                        queue.add(head.left);
                    }
                    if (head.right != null) {
                        queue.add(head.right);
                    }
                }
            }
            return sum;
        }

//        public Map.Entry<Integer, Integer> find(TreeNode root) {
//            //如果两边都是空，就是叶子节点
//            if (root.left == null && root.right == null) {
//                return new AbstractMap.SimpleEntry<>(0, root.val);
//            }//如果只有左边是空
//            else if (root.left == null) {
//                return new AbstractMap.SimpleEntry<>(find(root.right).getKey() + 1, find(root.right).getValue());
//            }//如果只有右边是空
//            else if (root.right == null) {
//                return new AbstractMap.SimpleEntry<>(find(root.left).getKey() + 1, find(root.left).getValue());
//            }//两边都不为空，但是两边的深度相同
//            else if (find(root.left).getKey() == find(root.right).getKey()) {
//                return new AbstractMap.SimpleEntry<>(find(root.left).getKey() + 1,
//                        find(root.left).getValue() + find(root.right).getValue());
//            }//两边都不为空，但是两边深度不一样
//            else {
//                return new AbstractMap.SimpleEntry<>(find(root.left).getKey() > find(root.right).getKey() ?
//                        find(root.left).getKey() + 1 : find(root.right).getKey() + 1,
//                        find(root.left).getKey() > find(root.right).getKey() ?
//                                find(root.left).getValue() : find(root.right).getValue());
//            }
//        }
    }
}
