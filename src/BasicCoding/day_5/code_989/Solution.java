package BasicCoding.day_5.code_989;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * completion time = 2022.10.2
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {0};
        Solution solution = new Solution();
        System.out.println(solution.addToArrayForm(arr, 34));
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        while (k != 0) {
            list.add(k % 10);
            k /= 10;
        }
        List<Integer> integers = new ArrayList<>();
        for (int n = list.size() - 1; n >= 0; n--) {
            integers.add(list.get(n));
        }
        List<Integer> ans = new ArrayList<>();
        int i = num.length - 1;
        int j = integers.size() - 1;
        int sum = 0;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            sum = (num[i] + integers.get(j) + carry) % 10;
            carry = (num[i] + integers.get(j) + carry) / 10;
            ans.add(sum);
            i--;
            j--;
        }
        while (i >= 0) {
            sum = (num[i] + carry) % 10;
            carry = (num[i] + carry) / 10;
            ans.add(sum);
            i--;
        }
        while (j >= 0) {
            sum = (integers.get(j) + carry) % 10;
            carry = (integers.get(j) + carry) / 10;
            ans.add(sum);
            j--;
        }
        if (carry != 0) {
            ans.add(carry);
        }
        List<Integer> re = new LinkedList<>();
        for (int n = ans.size() - 1; n >= 0; n--) {
            re.add(ans.get(n));
        }
        return re;
    }
}
