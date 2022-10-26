package TowardsOffer2.day_16_树.code_047_序列化与反序列化二叉树;


import java.util.*;

/**
 * completion time = 2022.10.26
 */
class Codec {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        Codec codec = new Codec();
        String s = codec.serialize(treeNode1);
        TreeNode treeNode = codec.deserialize(s);
        System.out.println(treeNode);


    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        dfs(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strings));
        return construct(list);
    }

    TreeNode construct(List<String> list) {
        String head = list.remove(0);
        if (head.equals("None")) {
            return null;
        }
        TreeNode now = new TreeNode(Integer.parseInt(head));
        now.left = construct(list);
        now.right = construct(list);
        return now;
    }

    void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("None,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
