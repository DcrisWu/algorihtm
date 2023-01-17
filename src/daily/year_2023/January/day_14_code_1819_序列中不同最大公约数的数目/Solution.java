package daily.year_2023.January.day_14_code_1819_序列中不同最大公约数的数目;

import java.util.Arrays;

class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        boolean[] occur = new boolean[maxNum + 1];
        for (int num : nums) {
            occur[num] = true;
        }
        int ans = 0;
        for (int i = 1; i <= maxNum; i++) {
            int sg = 0;
            for (int j = i; j <= maxNum; j += i) {
                if (occur[j]) {
                    if (sg == 0) {
                        sg = j;
                    } else {
                        sg = gcd(j, sg);
                    }
                    if (sg == i){
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = a == max ? b : a;
        while (max % min != 0) {
            int temp = max;
            max = min;
            min = temp % min;
        }
        return min;
    }
}