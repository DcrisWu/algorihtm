package competition.day_2022_9_18.code_6183;

public class Solution {
    public static void main(String[] args) {
        String a = "abc";
        System.out.println(a.substring(0,10));
    }

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            String pre = words[i];
            boolean[] judge = new boolean[n];
            while (!pre.isEmpty()){
                int size = pre.length();
                for (int j = 0; j < n; j++) {
                    if(words[j].length() < size || judge[j]){
                        continue;
                    }
                    if (words[j].substring(0, size).equals(pre)) {
                        ans[i] += size;
                        judge[j] = true;
                    }
                }
                pre = pre.substring(0, size - 1);
            }
        }
        return ans;
    }
}
