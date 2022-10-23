package algorithm.day_19.code_201;

import java.util.LinkedList;
import java.util.List;

/**
 * completion time = 2022.9.28
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd(3, 6));
    }

    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0 || right == 0) {
            return 0;
        }
        int min = 0, max = 32, temp_ans = 0;
        while (min <= max) {
            int mid = (min + max) >> 1;
            if (right - left < Math.pow(2, mid)) {
                temp_ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        List<Integer> temp_r = new LinkedList<>();
        while (right / 2 != 0) {
            temp_r.add(right % 2);
            right = right / 2;
        }
        temp_r.add(1);
        int[] r = new int[temp_r.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = temp_r.get(temp_r.size() - i - 1);
        }
        int[] l = new int[r.length];
        int index = l.length - 1;
        while (index >= 0 && left / 2 != 0) {
            l[index] = left % 2;
            index--;
            left /= 2;
        }
        l[index] = 1;


        StringBuilder s = new StringBuilder(new String(""));
        for (int i = 0; i < r.length - temp_ans; i++) {
            if (l[i] == r[i] && l[i] == 1) {
                s.append("1");
            }else {
                s.append("0");
            }
        }
        for (int i = 0;i<temp_ans;i++){
            s.append("0");
        }
        if (s.isEmpty()) {
            return 0;
        }
        int ans = Integer.parseInt(s.toString(), 2);
        return ans;
    }
}
