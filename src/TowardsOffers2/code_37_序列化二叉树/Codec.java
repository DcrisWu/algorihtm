package TowardsOffers2.code_37_序列化二叉树;

/**
 * completion time = 2022.12.28
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }

    void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        } else {
            sb.append(root.val);
            sb.append(',');
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        return construct(split);
    }

    private int index = 0;

    TreeNode construct(String[] split) {
        if (index >= split.length || split[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(split[index++]));
        treeNode.left = construct(split);
        treeNode.right = construct(split);
        return treeNode;
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        TreeNode deserialize = codec.deserialize(codec.serialize(n1));
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
