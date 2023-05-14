package 灵茶2022年周赛总结.下半年.模拟.code_2437_有效时间的数目;

/**
 * completion time = 2023.5.8
 */
class Solution {
    public int countTime(String time) {
        return count(time.substring(0, 2), 24) * count(time.substring(3), 60);
    }

    public int count(String time, int period) {
        int ans = 0;
        for (int i = 0; i < period; i++) {
            if ((time.charAt(0) == '?' || time.charAt(0) - '0' == i / 10) && (time.charAt(1) == '?' || time.charAt(1) - '0' == i % 10)) {
                ans++;
            }
        }
        return ans;
    }

}