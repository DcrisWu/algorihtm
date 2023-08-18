package ByteDance.code_165_比较版本号;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n = Math.max(s1.length, s2.length);
        for (int i = 0; i < n; i++) {
            Integer n1 = 0;
            Integer n2 = 0;
            if (i < s1.length) {
                n1 = Integer.valueOf(s1[i]);
            }
            if (i < s2.length) {
                n2 = Integer.valueOf(s2[i]);
            }
            if (n1 < n2) {
                return -1;
            }
            if (n1 > n2) {
                return 1;
            }
        }
        return 0;
    }
}
