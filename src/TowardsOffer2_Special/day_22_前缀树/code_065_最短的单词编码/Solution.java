package TowardsOffer2_Special.day_22_前缀树.code_065_最短的单词编码;

/**
 * completion time = 2022.11.2
 */
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Node node = new Node();
        // 一开始就将#放进字符串中
        int ans = 1;
        for (String word : words) {
            Node[] now = node.tree;
            boolean judge = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (now[word.charAt(i) - 'a'] == null) {
                    now[word.charAt(i) - 'a'] = new Node();
                    if (!judge) {
                        // 假设都是在原有的基础上添加
                        boolean isPlus = true;
                        for (int j = 0; j < 26; j++) {
                            if(word.charAt(i)-'a' == j){
                                continue;
                            }
                            // 说明是在分支上添加的
                            if(now[j] != null){
                                isPlus = false;
                                break;
                            }
                        }
                        if(isPlus){
                            ans += i+1;
                        }else {
                            ans += word.length()+1;
                        }
                        judge = true;
                    }
                }
                now = now[word.charAt(i) - 'a'].tree;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] arr = {"time", "me", "bell"};
        Solution solution = new Solution();
        System.out.println(solution.minimumLengthEncoding(arr));
    }
}

class Node {
    Node[] tree = new Node[26];
}
