package TowardsOffer2.day_31_动态规划.code_093_最长斐波那契数列;

/**
 * completion time = 2022.11.10
 */
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        /*int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                int now = 0;
                int first = arr[i];
                int second = arr[j];
                while (map.containsKey(first + second)) {
                    if (now == 0) {
                        now = 3;
                    } else {
                        now += 1;
                    }
                    int newThree = first + second;
                    first = second;
                    second = newThree;
                }
                ans = Math.max(ans, now);
            }
        }
        return ans;*/

//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            map.put(arr[i], i);
//        }

        int ans = 0;
        // 只用两个数的数组就可以确定一个斐波那契数列的连续三个数
        int[][] dp = new int[arr.length][arr.length];
        // 寻找每个数作为斐波那契数列时，最长的长度，不能构成斐波那契数列就为0
        for (int i = 2; i < arr.length; i++) {
            int first = 0, second = i - 1;
            while (first < second) {
                // 如果arr[first]+arr[second] == arr[i]，就找到了一个斐波那契数列
                if (arr[first] + arr[second] == arr[i]) {
                    // 先初始化
                    if (dp[second][i] == 0) {
                        dp[second][i] = 3;
                    }
                    dp[second][i] = Math.max(dp[second][i], dp[first][second] + 1);
                    // 记录下最大值
                    ans = Math.max(ans, dp[second][i]);
                    first++;
                    second--;
                } else if (arr[first] + arr[second] > arr[i]) {
                    // 如果如果arr[first]+arr[second] > arr[i]，说明和太大了，需要缩小
                    second--;
                } else {
                    // 和太小了
                    first++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(solution.lenLongestFibSubseq(arr));
    }
}