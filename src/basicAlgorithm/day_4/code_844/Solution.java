package basicAlgorithm.day_4.code_844;

/**
 * completion time = 2022.9.16
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("#ab#c", "ad#c"));
    }
    public boolean backspaceCompare(String s, String t) {
        StringBuffer s1 = new StringBuffer("");
        StringBuffer t1 = new StringBuffer("");
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!s1.isEmpty()) {
                    s1.deleteCharAt(s1.length() - 1);
                }
            } else {
                s1.append(s.charAt(i));
            }
        }
        for(int i = 0;i<t.length();i++){
            if (t.charAt(i) == '#') {
                if (!t1.isEmpty()) {
                    t1.deleteCharAt(t1.length() - 1);
                }
            } else {
                t1.append(t.charAt(i));
            }
        }
        return s1.toString().equals(t1.toString());
    }
}
