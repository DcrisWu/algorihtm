package TME.code_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    private int n;

    public TreeNode fun(TreeNode root) {
        // write code here
        int nodes = getNodes(root);
        this.n = nodes;
        int sum = (1 + nodes) * nodes / 2;
        boolean isSumOdd = sum % 2 == 1;
        int even = nodes / 2;
        int odd = nodes - even;
        Set<Integer> list = new HashSet<>();
        // 如果是和是偶数的话
        Set<Integer> evenList = backTrace(0, sum / 2, even, list);
        if (!isSumOdd) {
            if (evenList == null) {
                return null;
            }
        } else {
            if (evenList == null) {
                evenList = backTrace(0, sum / 2 + 1, even, list);
                if (evenList == null) {
                    return null;
                }
            }
        }
        Set<Integer> oddList = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (!evenList.contains(i)) {
                oddList.add(i);
            }
        }
        construct(root, evenList, oddList, 0);
        return root;
    }

    void construct(TreeNode root, Set<Integer> even, Set<Integer> odd, int level) {
        if (root == null) {
            return;
        }
        if (level % 2 == 0) {
            for (Integer integer : even) {
                root.val = integer;
                break;
            }
            even.remove(root.val);
        } else {
            for (Integer integer : odd) {
                root.val = integer;
                break;
            }
            odd.remove(root.val);
        }
        construct(root.left, even, odd, level + 1);
        construct(root.right, even, odd, level + 1);
    }

    int getNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getNodes(root.left) + getNodes(root.right);
    }

    Set<Integer> backTrace(int pre, int rest, int need, Set<Integer> have) {
        if (have.size() == need) {
            if (rest == 0) {
                return new HashSet<>(have);
            } else {
                return null;
            }
        }
        for (int i = pre + 1; i <= n; i++) {
            have.add(i);
            Set<Integer> list = backTrace(i, rest - i, need, have);
            have.remove(i);
            if (list != null) {
                return list;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode n2 = new TreeNode(-1);
        TreeNode n3 = new TreeNode(-1);
        TreeNode n1 = new TreeNode(-1);
        n1.left = n2;
        n1.right = n3;
        TreeNode fun = solution.fun(n1);
        System.out.println(fun.val);
    }
}
