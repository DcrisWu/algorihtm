package daily.year_2022.August;

import java.util.ArrayDeque;
import java.util.Deque;

public class august_27 {

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

    private static class Pair<T, I extends Number> {
        private TreeNode key;
        private Integer value;

        public void setKey(TreeNode key) {
            this.key = key;
        }

        public Pair(TreeNode key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Pair() {
        }

        public TreeNode getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

    public static int widthOfBinaryTree1(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode no = new TreeNode();
        int n = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            n = Math.max(n, len);
            for(int i = 0;i<len;i++){
                TreeNode head = queue.pollFirst();
                if(head == no){
                    queue.add(no);
                    queue.add(no);
                } else {
                    queue.add(head.left == null?no:head.left);
                    queue.add(head.right == null?no:head.right);
                }
            }
            while (!queue.isEmpty() && queue.getFirst() == no){
                queue.pollFirst();
            }
            while (!queue.isEmpty() && queue.getLast() == no){
                queue.pollLast();
            }
        }
        return n;
    }

    public static int widthOfBinaryTree(TreeNode root){
        Deque<Pair<TreeNode,Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(root,1));
        int len = 1;
        while (!queue.isEmpty()){
            len = Math.max(queue.peekLast().getValue()-queue.peekFirst().getValue()+1,len);
            int n = queue.size();
            for(int i= 0;i<n;i++){
                Pair<TreeNode, Integer> poll = queue.poll();
                TreeNode head = poll.getKey();
                if(head.left != null){
                    queue.offer(new Pair<>(head.left,poll.getValue()*2));
                }
                if(head.right != null){
                    queue.offer(new Pair<>(head.right,poll.getValue()*2+1));
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        TreeNode s1 = new TreeNode(1);
        s1.left = new TreeNode(3);
        s1.left.left = new TreeNode(5);
        s1.left.left.left = new TreeNode(6);
        s1.right = new TreeNode(2);
        s1.right.right = new TreeNode(9);
        s1.right.right.left = new TreeNode(7);
        System.out.println(widthOfBinaryTree1(s1));
        System.out.println(widthOfBinaryTree(s1));
    }
}
