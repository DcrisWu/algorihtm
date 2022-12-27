package daily.year_2022.December.day_27_code_2027_转换字符串的最少操作次数;

class Solution {
    public int minimumMoves(String s) {
        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'O') {
                i++;
            } else {
                if (i + 3 < s.length()) {
                    count++;
                    i += 3;
                } else {
                    break;
                }
            }
        }
        for (; i < s.length(); i++) {
            if (s.charAt(i) == 'X'){
                count++;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumMoves("OOOO"));

    }
}