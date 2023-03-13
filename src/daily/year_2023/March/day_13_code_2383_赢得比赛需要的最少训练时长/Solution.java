package daily.year_2023.March.day_13_code_2383_赢得比赛需要的最少训练时长;

/**
 * completion time = 2023.3.13
 */
class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int en = initialEnergy, ex = initialExperience;
        int ans = 0;
        for (int i = 0; i < energy.length; i++) {
            if (en - energy[i] > 0) {
                en -= energy[i];
            } else {
                ans += 1 - (en - energy[i]);
                en = 1;
            }
            if (ex <= experience[i]) {
                ans += experience[i] - ex + 1;
                ex += experience[i] - ex + 1;
            }
            ex += experience[i];
        }
        return ans;
    }
}
