package daily.year_2022.December.code_2037_使每位学生都有座位的最少移动次数;

import java.util.Arrays;

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for(int i = 0;i<seats.length;i++){
            ans += Math.abs(seats[i]-students[i]);
        }
        return ans;
    }
}
