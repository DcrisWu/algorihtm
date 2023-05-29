package basicAlgorithm.day_7.code_117;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * completion time = 2022.9.19
 */
public class Solution {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            //第一个
            Node pre = queue.poll();
            if(pre.left!=null){
                queue.add(pre.left);
            }
            if(pre.right!=null){
                queue.add(pre.right);
            }
            for(int i = 1;i<n;i++){
                Node next = queue.poll();
                pre.next = next;
                if(next.left!=null){
                    queue.add(next.left);
                }
                if(next.right!=null){
                    queue.add(next.right);
                }
                pre = next;
            }
        }
        return root;
    }
}
