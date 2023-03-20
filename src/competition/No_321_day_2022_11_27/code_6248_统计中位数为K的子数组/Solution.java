package competition.No_321_day_2022_11_27.code_6248_统计中位数为K的子数组;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countSubarrays(int[] nums, int k) {
        /*int pos = 0, n = nums.length;
        while (nums[pos] != k) ++pos;

        var cnt = new HashMap<Integer, Integer>();
        cnt.put(0, 1); // i=pos 的时候 c 是 0，直接记到 cnt 中，这样下面不是大于就是小于
        for (int i = pos + 1, c = 0; i < n; ++i) {
            c += nums[i] > k ? 1 : -1;
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }

        // 以下的值不加入到cnt中
        int ans = cnt.get(0) + cnt.getOrDefault(1, 0); // i=pos 的时候 c 是 0，直接加到答案中，这样下面不是大于就是小于
        for (int i = pos - 1, c = 0; i >= 0; --i) {
            c += nums[i] < k ? 1 : -1;
            ans += cnt.getOrDefault(c, 0) + cnt.getOrDefault(c + 1, 0);
        }
        return ans;*/
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                index = i;
                break;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // c表示从position->i中 > k的元素的个数
        for (int i = index + 1, c = 0; i < nums.length; i++) {
            c += nums[i] > k ? 1 : -1;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 0时候就是奇数时候符合的情况，1表示偶数时候符合的情况
        int ans = map.get(0) + map.getOrDefault(1, 0);
        // c 表示从0 ->position-1中， <k 的元素的个数
        for (int i = index-1, c = 0; i >= 0; i--) {
            // 假如这时候小于k的数为c
            // 我们需要在position -> nums.length-1中找到c个 > k的数 || c+1个 > k的数
            c += nums[i] < k ? 1 : -1;
            ans += map.getOrDefault(c, 0) + map.getOrDefault(c + 1, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5, 19, 11, 15, 13, 16, 4, 6, 2, 7, 10, 8, 18, 20, 1, 3, 17, 9, 12, 14};
//        int[] arr = {3, 2, 1, 4, 5};
        System.out.println(solution.countSubarrays(arr, 6));
    }
}