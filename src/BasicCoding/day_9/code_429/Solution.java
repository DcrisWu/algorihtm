package BasicCoding.day_9.code_429;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * completion time = 2022.10.7
 */
public class Solution {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new LinkedList<>();
        }
        List<List<Integer>> ans = new LinkedList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node poll = queue.poll();
                temp.add(poll.val);
                for (Node child : poll.children) {
                    queue.add(child);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
