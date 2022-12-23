package TowardsOffer2_Special.day_11_哈希表.code_034_外星语言是否排序;

/**
 * completion time = 2022.10.23
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alpha = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alpha[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String now = words[i];
            int p_len = pre.length();
            int n_len = now.length();
            int minLen = Math.min(p_len, n_len);
            boolean judge = false;
            for (int j = 0; j < minLen; j++) {
                if(alpha[pre.charAt(j)-'a'] == alpha[now.charAt(j)-'a']){
                    continue;
                } else if(alpha[pre.charAt(j)-'a'] < alpha[now.charAt(j)-'a']){
                    judge = true;
                    break;
                }else {
                    return false;
                }
            }
            if(!judge && n_len < p_len){
                return false;
            }
        }
        return true;
    }
}