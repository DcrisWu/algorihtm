package ByteDance.code_165_比较版本号;

/**
 * completion time = 2023.10.28
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int m = s1.length, n = s2.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            int a = Integer.parseInt(s1[i]);
            int b = Integer.parseInt(s2[i]);
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
            i++;
            j++;
        }
        while (i < m) {
            int a = Integer.parseInt(s1[i]);
            if (a > 0) {
                return 1;
            }
            i++;
        }
        while (j < n) {
            int a = Integer.parseInt(s2[j]);
            if (a > 0) {
                return -1;
            }
            j++;
        }
        return 0;
    }
}
