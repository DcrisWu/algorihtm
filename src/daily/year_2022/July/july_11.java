package daily.year_2022.July;

import java.util.Collections;
import java.util.HashSet;

public class july_11 {
    //    private List<String> dic;
    private HashSet<String> set;

    public july_11() {
        set = new HashSet<>();
    }

    public void buildDict(String[] dictionary) {
        Collections.addAll(set, dictionary);
    }

    public boolean search(String searchWord) {

        int n = searchWord.length();//n表示字符的长度
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (searchWord.charAt(i) == 'a' + j) {
                    //如果要替换的字母跟原来的一样，就跳过
                    continue;
                }
                //否则尝试替换这个字母，看是否匹配字典
                StringBuilder sb = new StringBuilder(searchWord);
                sb.setCharAt(i, (char) ('a' + j));
                if(set.contains(sb.toString())){
                    return true;
                }
            }
        }
        //循环一圈后发现都不匹配，就返回false
        return false;
    }

    public static void main(String[] args) {
        july_11 july_11 = new july_11();
        String[] arr = {"hello", "leetcode"};
        String a = "helll";
        july_11.buildDict(arr);
        System.out.println(july_11.search(a));
    }
}
