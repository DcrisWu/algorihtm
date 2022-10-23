package daily;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class august_20 {

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


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int max = findMax(nums, begin, end);
        TreeNode root = new TreeNode(nums[max]);
        root.left = construct(nums, begin, max - 1);
        root.right = construct(nums, max + 1, end);
        return root;
    }

    //[begin,end]都是闭区间，max是最大值的下标
    public int findMax(int[] nums, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int max = begin;
        for (int i = begin; i <= end; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
