package TowardsOffers2.code_66_构建乘积数组;

class Solution {
    public int[] constructArr(int[] a) {
        // 前缀积
        int[] preProduct = new int[a.length];
        // 后缀积
        int[] postProduct = new int[a.length];
        int now = 1;
        for (int i = 0; i < a.length; i++) {
            now *= a[i];
            preProduct[i] = now;
        }
        now = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            now *= a[i];
            postProduct[i] = now;
        }
        int[] ans = new int[a.length];
        for (int i = 0; i < ans.length; i++) {
            if (i == 0) {
                if (ans.length > 1) {
                    ans[i] = postProduct[1];
                }
                continue;
            }
            if (i == ans.length - 1) {
                ans[i] = preProduct[i - 1];
                continue;
            }
            ans[i] = preProduct[i - 1] * postProduct[i + 1];
        }
        return ans;
    }
}
