package BasicCoding.day_10.code_556;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * completion time = 2022.10.7
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreaterElement(2147483476));
    }

    public int nextGreaterElement(int n) {
        List<Integer> temp = new ArrayList<>();
        while (n != 0) {
            temp.add(n % 10);
            n /= 10;
        }
        boolean judge = false;
        for (int i = 0; i < temp.size() - 1; i++) {
            if (temp.get(i) > temp.get(i + 1)) {
                int mark = i;
                for (int j = 0; j < i + 1; j++) {
                    if (temp.get(j) < temp.get(mark) && temp.get(j) > temp.get(i + 1)) {
                        mark = j;
                    }
                }
                int b = temp.get(i + 1);
                temp.set(i + 1, temp.get(mark));
                temp.set(mark, b);
//                int a = temp.get(i);
//                temp.set(i, temp.get(i + 1));
//                temp.set(i + 1, a);
                int[] arr = new int[i + 1];
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = temp.get(j);
                }
                Arrays.sort(arr);
                for (int j = 0; j < arr.length; j++) {
                    temp.set(j, arr[arr.length - j - 1]);
                }
                judge = true;
                break;
            }
        }
        if (judge) {
            StringBuffer sb = new StringBuffer("");
            for (Integer integer : temp) {
                sb.append(integer);
            }
            try {
                int parseInt = Integer.parseInt(sb.reverse().toString());
                return parseInt;
            } catch (NumberFormatException e) {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
