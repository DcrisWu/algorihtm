package classification.最长递增子序列.code_354_俄罗斯套娃信封问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 排序有技巧
        // 先按x排序，为了让x相同，但是y不同的信封也可以正常处理，需要将y按降序排列
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        List<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);
        for (int i = 1; i < n; i++) {
            // 如果 y 大于上一个y，那么x 一定大于上一个x
            // 因为假如 x 等于上一个 x，而相等的x的y按降序排列
            // 如果y等于上一个y，那么x一定大于上一个x
            if (envelopes[i][1] > list.get(list.size() - 1)) {
                list.add(envelopes[i][1]);
            } else {
                // 当x相等时候
                int l = 0, r = list.size() - 1;
                int idx = list.size();
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (list.get(mid) >= envelopes[i][1]) {
                        idx = mid;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                if (idx == list.size()) {
                    list.add(envelopes[i][1]);
                } else {
                    list.set(idx, envelopes[i][1]);
                }
            }
        }

        return list.size();
    }

    public static void main(String[] args) {
        int[][] arr = {{4, 2}, {4, 6}, {6, 7}, {2, 3}, {1, 1}, {1, 1}};
//        int[][] arr = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
//        int[][] arr = {{1, 1}, {1, 1}, {1, 1}};
        System.out.println(new Solution().maxEnvelopes(arr));
    }
}