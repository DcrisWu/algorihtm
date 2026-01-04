package daily.year_2026.January.day_4_code_1390_四因数;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            Set<Integer> set = new HashSet<>();
            set.add(1);
            set.add(num);
            for (int i = 2; i < num; i++) {
                int j = num / i;
                if(num % i == 0){
                    set.add(i);
                    set.add(j);
                }
                if (j < i || set.size() > 4){
                    break;
                }
            }
            if (set.size() != 4){
                continue;
            }
            for (Integer i : set) {
                sum += i;
            }
        }
        return sum;
    }
}