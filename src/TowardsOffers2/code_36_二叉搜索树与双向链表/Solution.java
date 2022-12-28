package TowardsOffers2.code_36_二叉搜索树与双向链表;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n2 = new Node(2, n1, n3);
        Node n5 = new Node(5);
        Node n4 = new Node(4, n2, n5);
        Node node = solution.treeToDoublyList(n4);
        System.out.println(node);
    }
    private Node head;
    private Node tail;

    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        Node begin = root;
        while (begin != null) {
            head = begin;
            begin = begin.left;
        }
        tail = head;
        inorder(root);
        tail.right = head;
        head.left = tail;
        return head;
    }

    void inorder(Node root) {
        if (root == null){
            return;
        }
        inorder(root.left);
        if (head != root){
            tail.right = root;
            root.left = tail;
            tail = tail.right;
        }
        inorder(root.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
