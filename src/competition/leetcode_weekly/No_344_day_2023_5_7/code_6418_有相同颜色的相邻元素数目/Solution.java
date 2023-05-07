package competition.leetcode_weekly.No_344_day_2023_5_7.code_6418_有相同颜色的相邻元素数目;

/**
 * completion time = 2023.5.7
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queries =
        {{11,3},{5,1},{16,2},{4,4},{5,1},{13,2},{15,1},{15,3},{8,1},{14,4},{1,3},{6,2},{8,2},{2,2},{3,4},{7,1},{10,2},{14,3},{6,5},{3,5},{5,5},{9,2},{2,3},{3,3},{4,1},{12,1},{0,4},{16,4},{8,1},{14,3},{15,3},{12,1},{11,5},{3,1},{2,4},{10,1},{14,5},{15,5},{5,2},{8,1},{6,5},{10,2}};
        int[] colorTheArray = solution.colorTheArray(17, queries);
        for (int i : colorTheArray) {
            System.out.println(i);
        }
    }
    public int[] colorTheArray(int n, int[][] queries) {
        int[] nums = new int[n];
        int count = 0;
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int color = queries[i][1];
            // 涂色前
            // count需不需要减，只需要考虑涂过色的情况，没涂过色就直接跳过
            if (nums[index] != 0) {
                // 如果涂色前后颜色不一致
                if (color != nums[index]) {
                    // 如果涂色前 index 与 index - 1的颜色一样，count--
                    if (index > 0 && nums[index] == nums[index - 1]) {
                        count--;
                    }
                    // 如果涂色前 index 与 index + 1的颜色一样，count--
                    if (index < n - 1 && nums[index] == nums[index + 1]) {
                        count--;
                    }
                }else {
                    res[i] = count;
                    continue;
                }
            }
            // 涂色
            nums[index] = color;
            // 如果涂色后 index 与 index - 1的颜色一样，count--
            if (index > 0 && nums[index] == nums[index - 1]) {
                count++;
            }
            // 如果涂色前 index 与 index + 1的颜色一样，count--
            if (index < n - 1 && nums[index] == nums[index + 1]) {
                count++;
            }
            res[i] = count;
        }
        return res;
    }
}
