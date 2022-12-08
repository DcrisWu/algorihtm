package Random.code_440_字典序的第K小数字;

class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        // 一定要先减一
        // 如果k=1就不进入下面的循环。之间返回1
        k--;
        while (k > 0) {
            int count = getCount(current, n);
            // 说明以count为前缀的数的数量 <= k，就要往兄弟节点去找
            if (count <= k) {
                current++;
                k -= count;
                // 往子节点去找
            } else {
                current *= 10;
                k--;
            }
        }
        return current;
    }

    // 返回以prefix为前缀，上限为ceiling的数的个数
    int getCount(int prefix, long ceiling) {
        int count = 0;
        long first = prefix;
        long last = prefix;
        while (first <= ceiling) {
            count += Math.min(last, ceiling) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }
        return count;
    }
}