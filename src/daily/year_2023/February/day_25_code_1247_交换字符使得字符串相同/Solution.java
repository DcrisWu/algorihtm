package daily.year_2023.February.day_25_code_1247_交换字符使得字符串相同;

/**
 * completion time = 2023.2.25
 */
class Solution {
    public int minimumSwap(String s1, String s2) {
        /*char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int x = 0, y = 0;
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] == 'x') {
                x++;
            } else {
                y++;
            }
            if (ch2[i] == 'x') {
                x++;
            } else {
                y++;
            }
        }
        // 如果永远不可能交换后符合题意，就返回-1
        if (x % 2 != 0 || y % 2 != 0) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] == ch2[i]) {
                continue;
            }
            boolean back1 = false;
            boolean back2 = false;
            int backIndex = 0;
            for (int j = i + 1; j < ch1.length; j++) {
                if (ch1[j] == ch1[i] && ch2[j] == ch2[i]) {
                    back1 = true;
                    ch1[i] = ch2[i];
                    ch2[j] = ch1[j];
                    count++;
                    break;
                }
                if (ch1[i] == ch2[j] && ch2[i] == ch1[j]) {
                    backIndex = j;
                    back2 = true;
                }
            }
            if (back1) {
                continue;
            }
            if (back2) {
                ch1[i] = ch2[i];
                ch1[backIndex] = ch2[backIndex];
                count += 2;
            }
        }
        return count;*/

        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int xy = 0, yx = 0;
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] == ch2[i]) {
                continue;
            }
            if (ch1[i] == 'x' && ch2[i] == 'y') {
                xy++;
            }
            if (ch1[i] == 'y' && ch2[i] == 'x') {
                yx++;
            }
        }
        if ((xy + yx) % 2 != 0) {
            return -1;
        }
        return xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }
}
