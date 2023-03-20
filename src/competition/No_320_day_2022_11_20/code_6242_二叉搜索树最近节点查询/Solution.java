package competition.No_320_day_2022_11_20.code_6242_二叉搜索树最近节点查询;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>(queries.size());
        List<Integer> sort = new ArrayList<>();
        toList(root, sort);
        Integer[] array = sort.toArray(new Integer[0]);
        for (int i = 0; i < queries.size(); i++) {
            int min = lessThan(queries.get(i), array);
            int max = greaterThan(queries.get(i), array);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(min);
            list.add(max);
            ans.add(list);
        }
        return ans;
    }

    int lessThan(int target, Integer[] nums) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= target) {
                ans = nums[mid];
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    int greaterThan(int target, Integer[] nums) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                ans = nums[mid];
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    void toList(TreeNode root, List<Integer> sort) {
        if (root == null) {
            return;
        }
        toList(root.left, sort);
        sort.add(root.val);
        toList(root.right, sort);
    }

    /*int lessThan(TreeNode root, int target) {
        if (root == null) {
            return -1;
        }
        if (root.val > target) {
            return lessThan(root.left, target);
        } else {
            int ans = root.val;
            int i = lessThan(root.right, target);
            if (i != -1) {
                ans = Math.max(ans, i);
            }
            return ans;
        }
    }

    int greaterThan(TreeNode root, int target) {
        if (root == null) {
            return -1;
        }
        if (root.val < target) {
            return greaterThan(root.right, target);
        } else {
            int ans = root.val;
            int i = greaterThan(root.left, target);
            if (i != -1) {
                ans = Math.min(ans, i);
            }
            return ans;
        }
    }*/
}
