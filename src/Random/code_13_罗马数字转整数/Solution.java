package Random.code_13_罗马数字转整数;

class Solution {
    private int index;
    private String s;

    public int romanToInt(String s) {
        this.index = 0;
        this.s = s;
        int ans = 0;
        int nextNum = getNextNum();
        while (nextNum != -1){
            ans += nextNum;
            nextNum = getNextNum();
        }
        return ans;
    }

    int getNextNum() {
        if (index >= s.length()){
            return -1;
        }
        char now = s.charAt(index);
        switch (now) {
            case 'I':
                if (index < s.length() - 1) {
                    char next = s.charAt(index + 1);
                    if (next == 'V' || next == 'X') {
                        index += 2;
                        return next == 'V' ? 4 : 9;
                    } else {
                        index++;
                        return 1;
                    }
                }else {
                    index++;
                    return 1;
                }
            case 'X':
                if (index < s.length() - 1) {
                    char next = s.charAt(index + 1);
                    if (next == 'L' || next == 'C') {
                        index += 2;
                        return next == 'L' ? 40 : 90;
                    } else {
                        index++;
                        return 10;

                    }
                }else {
                    index++;
                    return 10;
                }
            case 'C':
                if (index < s.length() - 1) {
                    char next = s.charAt(index + 1);
                    if (next == 'D' || next == 'M') {
                        index += 2;
                        return next == 'D' ? 400 : 900;
                    } else {
                        index++;
                        return 100;
                    }
                }else {
                    index++;
                    return 100;
                }
            case 'V':
                index++;
                return 5;
            case 'L':
                index++;
                return 50;
            case 'D':
                index++;
                return 500;
            case 'M':
                index++;
                return 1000;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}