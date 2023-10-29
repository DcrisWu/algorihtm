package ByteDance.code_440_字典序的第K小数字;


/**
 * completion time = 2023.10.29
 */
class Solution {
    public int findKthNumber(int n, int k) {
        // 由于cur可能会很大,因此int可能计算过程中会溢出,用long类型
        long cur = 1;
        // 当 k == 1时候，就是答案
        while (k > 1) {
            int cnt = getNodes(n, cur);
            if (cnt < k) {
                // 说明以 cur为根的字典树的个数不够
                cur++;
                // 只需要在next为根的字典树中找到 k - cnt个就可以了
                // 因为cnt < k恒成立，所以 k -= cnt > 0恒成立
                k -= cnt;
            } else {
                // cnt >= k，说明以 cur 为根的个数太多了，此时需要往下遍历
                // 往下遍历，此时 k -= 1
                cur *= 10;
                // 因为 k > 1恒成立，k--最多使 k == 1
                k--;
            }
        }
        return (int) cur;
    }

    /*
    计算[1,n]内以cur为根(开头)的节点个数
    */
    private int getNodes(int n, long cur) {
        long next = cur + 1;
        int cnt = 0;
        while (cur <= n) {
            cnt += (int) Math.min(n - cur + 1, next - cur);
            cur *= 10;
            next *= 10;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthNumber(10, 3));
    }
}

