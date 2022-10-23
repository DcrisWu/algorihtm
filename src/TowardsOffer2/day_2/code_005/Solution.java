package TowardsOffer2.day_2.code_005;

/**
 * completion time = 2022.10.15
 */
class Solution {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        //将字符串转为二进制整数
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int temp = 0;
            for (int j = 0; j < word.length(); j++) {
                temp = (1 << (word.charAt(j) - 'a')) | temp;
            }
            mask[i] = temp;
            System.out.println(Integer.toBinaryString(mask[i]));
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans,words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"abcw","baz","foo","bar","fxyz","abcdef"};
        System.out.println(solution.maxProduct(arr));
    }
}
