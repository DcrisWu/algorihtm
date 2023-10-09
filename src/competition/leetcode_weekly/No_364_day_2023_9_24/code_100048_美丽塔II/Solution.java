package competition.leetcode_weekly.No_364_day_2023_9_24.code_100048_美丽塔II;

import java.util.*;

class Solution {
    // 第三题
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        long[] left = new long[n];
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && maxHeights.get(st.peek()) >= maxHeights.get(i)) {
                st.pop();
            }
            if (st.size() == 1) {
                left[i] = (long) maxHeights.get(i) * (long)(i + 1);
            } else {
                Integer preIdx = st.peek();
                left[i] = left[preIdx] + (long)maxHeights.get(i) * (long)(i - preIdx);
            }
            st.push(i);
        }
        long[] right = new long[n];
        st.clear();
        st.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 1 && maxHeights.get(st.peek()) >= maxHeights.get(i)) {
                st.pop();
            }
            if (st.size() == 1) {
                right[i] = (long) maxHeights.get(i) * (long) (n - i);
            } else {
                Integer preIdx = st.peek();
                right[i] = right[preIdx] + (long) maxHeights.get(i) * (long) (preIdx - i);
            }
            st.push(i);
        }
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, left[i] + right[i] - maxHeights.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(528947205, 446572672, 245562434, 29067688, 230940022, 237916991, 546243960, 898360263, 110809423, 616740838, 141189952, 272319413, 173945434, 944209607, 709147298, 291516002, 697109513, 945372506, 321357175, 271013697, 140905315, 154122459, 745184252, 379717676, 468969774, 302949377, 261867781, 933328834, 791272529, 583341139, 83259489, 304055888, 873655860, 808520318, 194518325, 703266873, 281331446, 927210596, 422874036, 902047413, 774474564, 809609201, 493545785, 415250991, 884864225, 392444408, 610159103, 903379193, 816412790, 591760883, 361140449, 759810143, 588717612, 694204370, 42665571, 517507625, 702706955, 952884579);
        System.out.println(new Solution().maximumSumOfHeights(list));
    }
}
