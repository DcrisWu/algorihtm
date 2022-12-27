package TowardsOffers2.code_33_二叉搜索树的后序遍历序列;

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return isPost(postorder, 0, postorder.length - 1);
    }

    boolean isPost(int[] postorder, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int root = postorder[end];
        int big_begin = end;
        for (int i = end - 1; i >= begin; i--) {
            if (postorder[i] > root) {
                big_begin = i;
            } else {
                break;
            }
        }
        int small_begin = big_begin;
        for (int i = small_begin - 1; i >= begin; i--) {
            if (postorder[i] < root) {
                small_begin = i;
            } else {
                break;
            }
        }
        if (small_begin > begin) {
            return false;
        }
        return isPost(postorder, small_begin, big_begin - 1) && isPost(postorder, big_begin, end - 1);
    }
}
